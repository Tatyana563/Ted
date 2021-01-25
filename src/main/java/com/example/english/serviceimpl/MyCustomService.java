package com.example.english.serviceimpl;

import com.example.english.dto.CatalogDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class MyCustomService {
    @PersistenceContext
    private EntityManager entityManager;


    public List<CatalogDto>  getCatalogStatistic() {
        return entityManager.createQuery("select new com.example.english.dto.CatalogDto(t.catalog.id, t.catalog.heading, count(t)) " +
                "from Task t group by t.catalog.id, t.catalog.heading", CatalogDto.class)
                .getResultList();

        //TODO: implement another version of method, using tuples (Object[])
    }
}
