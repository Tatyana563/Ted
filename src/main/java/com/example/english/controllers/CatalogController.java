package com.example.english.controllers;

import com.example.english.model.Catalog;
import com.example.english.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/english/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public void createFromPost(@RequestBody Catalog catalog) {
        catalogService.save(catalog);
    }

}


