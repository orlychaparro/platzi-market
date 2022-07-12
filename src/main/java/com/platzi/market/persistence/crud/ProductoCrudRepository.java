package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { // implementa interface CrudRepository<> Parametros entity Producto, tipo de dato del id producto

    // si se usa el sql nativo
    // @Query(value= "SELECT * FROM PRODUCTOS WHERE id_categoria = ?", nativeQuery = true)
    // List<Producto> getByCategoria(int IdCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
