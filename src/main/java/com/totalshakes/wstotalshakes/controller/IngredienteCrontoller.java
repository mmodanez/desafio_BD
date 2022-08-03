package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.exception.IngredienteCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingrediente")
public class IngredienteCrontoller {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping
    public ResponseEntity<HttpStatus> saveIngrediente(@RequestBody Ingrediente ingrediente) throws IngredienteCadastradoException {
        ingredienteService.saveIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> findIngredienteById(@RequestBody @PathVariable int id) throws IngredienteNaoEncontradoException {
        ingredienteService.findIngredienteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Implementar método de GetAllIngredientes

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateIngrediente(@PathVariable int id, @RequestBody String ingrediente) throws IngredienteNaoEncontradoException {
        ingredienteService.updateIngrediente(id, ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/(id)")
    public ResponseEntity<HttpStatus> deleteIngredienteById(@PathVariable int id) throws IngredienteNaoEncontradoException {
        ingredienteService.deleteIngredienteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
