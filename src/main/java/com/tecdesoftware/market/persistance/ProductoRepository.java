package com.tecdesoftware.market.persistance;

import com.tecdesoftware.market.persistance.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistance.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Devolverá todos los productos
    public List <Producto> getAll(){
        //Castear
        return (List<Producto>) productoCrudRepository.findAll();
    }

}
