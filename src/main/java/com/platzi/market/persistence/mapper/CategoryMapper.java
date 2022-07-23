package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
* Se efine Category como toCategory y se pasa Categoria para mapear los atributos de categoria a Category
* con Mappings se mapean cada campo de categoria (español) a category(ingles)
* */
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria" , target = "categoryId"),
            @Mapping(source = "descripcion" , target = "category"),
            @Mapping(source = "estado" , target = "active"),
    })
    Category toCategory(Categoria categoria);
    /*
    * Se hace la inversa, Categoria a toCategoria (español) (se pasa category (ingles)
    * usa la anotacion InheriInverseConfiguration que hace la inversa de los mappings definidos
    * es decir mapea del ingles al español cada atributo.
    * */

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true) // indica que no se mapea el atributo productos
    Categoria toCategoria(Category category);
}
