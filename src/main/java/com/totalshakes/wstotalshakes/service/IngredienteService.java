package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.model.Ingrediente;

public interface IngredienteService {

    void saveIngrediente(Ingrediente ingrediente);
    Ingrediente findIngredienteById(int id);
    void updateIngrediente(int id, String ingrediente);

    void deleteIngredienteById(int id);

}
