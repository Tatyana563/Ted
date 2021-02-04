package com.example.english.serviceimpl;



import com.example.english.dto.CatalogDto;
import com.example.english.dto.NewCatalogDto;
import com.example.english.dto.SentenceDto;
import com.example.english.mappers.NewCatalogDtoMapper;
import com.example.english.model.Catalog;
import com.example.english.model.Task;


import com.example.english.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import java.util.*;

@Service
@RequiredArgsConstructor
public class MyCustomService {
    @PersistenceContext
    private final EntityManager entityManager;

    private final TaskRepository taskRepository;
    private final NewCatalogDtoMapper newCatalogDtoMapper;

    //Using a Constructor in HQL
    public List<CatalogDto> getCatalogStatistic() {
        return entityManager.createQuery("select new com.example.english.dto.CatalogDto(t.catalog.id, t.catalog.heading, count(t)) " +
                "from Task t group by t.catalog.id, t.catalog.heading", CatalogDto.class)
                .getResultList();
    }

    //A Custom Query Result Class
    public List<CatalogDto> getCatalogStatistic2() {
        List<Object[]> list = entityManager.createQuery("select  t.catalog.id, t.catalog.heading, count(t) " +
                "from Task t group by t.catalog.id, t.catalog.heading", Object[].class).getResultList();
        List<CatalogDto> result = new ArrayList<>();
        for (Object[] row : list) {
            CatalogDto catalogDto = new CatalogDto();
            catalogDto.setId((Integer) row[0]);
            catalogDto.setHeading((String) row[1]);
            catalogDto.setTasksCount((Long) row[2]);
            result.add(catalogDto);
        }
        return result;


    }

    public List<CatalogDto> getCatalogStatistic3() {
        Query query = entityManager.createQuery("select  t.catalog.id, t.catalog.heading, count(t) " +
                "from Task t group by t.catalog.id, t.catalog.heading")
                .unwrap(Query.class).setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        return new CatalogDto(
                                (int) tuple[0], (String) tuple[1], (long) tuple[2]
                        );
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                });
        List resultList = query.getResultList();
        return resultList;
    }

    //Using a Constructor in HQL
    public List<CatalogDto> getTaskCountByCatalogId(int id) {
        TypedQuery<CatalogDto> query = entityManager.createQuery("select new com.example.english.dto.CatalogDto(t.catalog.id, t.catalog.heading, count(t)) " +
                "from Task t  where t.catalog.id=:catalogId group by t.catalog.id, t.catalog.heading", CatalogDto.class);
        query.setParameter("catalogId", id);
        return query.getResultList();
    }

    public NewCatalogDto getTasksByCatalogId(int catalogId) {
        List<String> wordsByCatalogId = taskRepository.findWordsByCatalogId(catalogId);
        Collections.shuffle(wordsByCatalogId);
        List<SentenceDto> sentenceDtoByCatalogId = taskRepository.findSentenceDtoByCatalogId(catalogId);
        NewCatalogDto catalogDto = new NewCatalogDto(catalogId, sentenceDtoByCatalogId, wordsByCatalogId);
        System.out.println(catalogDto);
        return catalogDto;
    }

    public NewCatalogDto getTasksByCatalogId_2(int catalogId) {
        List<String> wordsByCatalogId = taskRepository.findWordsByCatalogId(catalogId);
        Collections.shuffle(wordsByCatalogId);
        //  List<SentenceDto> sentenceDtoByCatalogId = taskRepository.findSentenceDtoByCatalogId(catalogId);
        List<SentenceDto> sentenceDtoByCatalogId = entityManager.createNamedQuery("SentenceDto", SentenceDto.class)
                .setParameter(1,catalogId)
                .getResultList();

        NewCatalogDto catalogDto = new NewCatalogDto(catalogId, sentenceDtoByCatalogId, wordsByCatalogId);
        System.out.println(catalogDto);
        return catalogDto;
    }


    public NewCatalogDto getTasksByCatalogId_3(int catalogId) {
        EntityGraph entityGraph = entityManager.getEntityGraph("new-catalog-dto-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Catalog catalog = entityManager.find(Catalog.class, catalogId, properties);
//        Set<Task> tasks = catalog.getTasks();
//        List<String> words = new ArrayList<>();
//        List<SentenceDto> sentenceList = new ArrayList<>();
//        for (Task task : tasks) {
//            String word = task.getWord();
//            words.add(word);
//            SentenceDto sentenceDto = new SentenceDto(task.getId(), task.getSentence());
//            sentenceList.add(sentenceDto);
//        }
//        NewCatalogDto catalogDto = new NewCatalogDto(catalogId, sentenceList, words);
//        entityManager.close();
//        System.out.println(catalogDto);
        return newCatalogDtoMapper.fromEntity(catalog);
    }
}