package com.example.english.services;

import com.example.english.model.Catalog;

public interface CatalogService {
   Catalog findByHeading(String heading);
}
