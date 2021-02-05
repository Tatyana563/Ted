package com.example.english.mappers;

import com.example.english.dto.creation.NewArticleRequest;
import com.example.english.model.Catalog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreationMapper {
    //TODO: implement mappers for article creation.


    @Mapping(target = "heading", source = "name")
    Catalog toCatalogEntity(NewArticleRequest newArticleRequest);


}


