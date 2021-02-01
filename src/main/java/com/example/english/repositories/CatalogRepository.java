package com.example.english.repositories;

import com.example.english.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Optional<Catalog> findById(int id);

}
