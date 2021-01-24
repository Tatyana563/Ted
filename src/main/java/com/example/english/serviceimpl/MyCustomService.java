package com.example.english.serviceimpl;

import com.example.english.dto.CatalogDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MyCustomService {
    @PersistenceContext
    private EntityManager entityManager;


    public List<CatalogDto>  method() {
        return entityManager.createQuery("select new com.example.english.dto.CatalogDto(t.catalog.id, t.catalog.heading, count(t)) " +
                "from Task t group by t.catalog", CatalogDto.class)
                .getResultList();

        //TODO: implement another version of method, using tuples (Object[])
    }
}
