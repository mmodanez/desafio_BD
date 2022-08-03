package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.exception.IngredienteCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;

public interface IngredienteService {

    void saveIngrediente(Ingrediente ingrediente) throws IngredienteCadastradoException;

    Ingrediente findIngredienteById(int id) throws IngredienteNaoEncontradoException;

    void updateIngrediente(int id, String ingrediente) throws IngredienteNaoEncontradoException;

    void deleteIngredienteById(int id) throws IngredienteNaoEncontradoException;

}
