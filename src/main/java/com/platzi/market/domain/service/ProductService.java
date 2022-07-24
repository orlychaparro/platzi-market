package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoriId){
        return productRepository.getByCategory(categoriId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
   // retorna boolean porque pregunta si existe el producto y si borró (true) si ni existe no borra (false)
    public boolean delete(int productId){   // pregunta si el producto existe, si existe borra y retorna true, si no existe, retorna false
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);



    }
    /*
    ejemplo 2 de delete con if else usando getProduct().isPresent().
    public  boolean delete2(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }
    }

     */



}
