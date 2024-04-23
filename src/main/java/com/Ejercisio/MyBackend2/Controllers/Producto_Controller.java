package com.Ejercisio.MyBackend2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ejercisio.MyBackend2.Models.Producto;
import com.Ejercisio.MyBackend2.Repository.Producto_Repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class Producto_Controller {  
    @Autowired
    private   Producto_Repository producto_Repository;

    @GetMapping
    public List<Producto> GetAllProductos(){
        return producto_Repository.findAll();
    }
    @GetMapping("/{id}")
    public Producto GetProductosById(@PathVariable Long id){
        return producto_Repository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto CreateProducto(@RequestBody Producto producto){

        return producto_Repository.save(producto);
    }
    @PutMapping("/{id}")
    public Producto UpdateProducto(@PathVariable Long id, @RequestBody Producto  producto){
        producto.setId(id);
        return producto_Repository.save(producto);
    }
    @DeleteMapping("/{id}")
    public void  DeleteProducto(@PathVariable Long id){
        producto_Repository.deleteById(id);
    }
}

