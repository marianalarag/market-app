package com.tecdesoftware.market.persistence;

import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Le decimos a Spring que esta clase se comunicará con BD
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Devolverá todos los productos
    public List <Producto> getAll(){
        //Castear
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return ProductoRepository.findByCantidadLessThan(cantidad,true);
    }

    private static Optional<List<Producto>> findByCantidadLessThan(int cantidad, boolean b) {
        return Optional.empty();
    }
    public Producto save (Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete (int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
