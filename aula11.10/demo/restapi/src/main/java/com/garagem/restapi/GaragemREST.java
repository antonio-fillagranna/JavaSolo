package com.garagem.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garagem.restapi.database.repositorioGaragem;
import com.garagem.restapi.entities.Car;

@RestController
@RequestMapping("/car")

public class GaragemREST {
    @Autowired
    private repositorioGaragem repositorio;

    @GetMapping
    public List<Car> listar(){
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Car car){
        repositorio.save(car);
    }

    @PutMapping
    public void alterar(@RequestBody Car car){
        if(car.getId() > 0)
            repositorio.save(car);
    }

    @DeleteMapping
    public void excluir(@RequestBody Car car){
        repositorio.delete(car);
    }


}
