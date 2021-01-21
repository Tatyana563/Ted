package com.example.english.serviceimpl;

import com.example.english.model.Catalog;
import com.example.english.repositories.CatalogRepository;
import com.example.english.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public Catalog findByHeading(String heading) {
       return catalogRepository.findByHeading(heading);
    }
}
