package com.example.english.serviceimpl;

import com.example.english.dto.CatalogDto;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyCustomService {
    @PersistenceContext
    private EntityManager entityManager;

    //Using a Constructor in HQL
    public List<CatalogDto> getCatalogStatistic() {
        return entityManager.createQuery("select new com.example.english.dto.CatalogDto(t.catalog.id, t.catalog.heading, count(t)) " +
                "from Task t group by t.catalog.id, t.catalog.heading", CatalogDto.class)
                .getResultList();

        //TODO: implement another version of method, using tuples (Object[])
    }

    //A Custom Query Result Class
    public List<CatalogDto> getCatalogStatistic2() {
        Session session = entityManager.unwrap(Session.class);
        List<Object[]> list = session.createQuery("select  t.catalog.id, t.catalog.heading, count(t) " +
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
      //  Session session = entityManager.unwrap(Session.class);
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

    //TODO: implement another version of method, using tuples (Object[])
}

