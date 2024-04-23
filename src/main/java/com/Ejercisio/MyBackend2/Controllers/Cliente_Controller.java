package com.Ejercisio.MyBackend2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ejercisio.MyBackend2.Models.Cliente;
import com.Ejercisio.MyBackend2.Repository.Cliente_Repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/clientes")
public class Cliente_Controller {  
    @Autowired
    private   Cliente_Repository cliente_Repository;

    @GetMapping
    public List<Cliente> GetAllClientes(){
        return cliente_Repository.findAll();
    }
    @GetMapping("/{id}")
    public Cliente GetClientesById(@PathVariable Long id){
        return cliente_Repository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente CreateCliente(@RequestBody Cliente cliente){

        return cliente_Repository.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente UpdateCliente(@PathVariable Long id, @RequestBody Cliente  cliente){
        cliente.setIdCliente(id);
        return cliente_Repository.save(cliente);
    }
    @DeleteMapping("/{id}")
    public void  DeleteCliente(@PathVariable Long id){
        cliente_Repository.deleteById(id);
    }
}
