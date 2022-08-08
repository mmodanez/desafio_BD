package com.totalshakes.wstotalshakes.exception;

public class IngredienteCadastradoException extends Exception {
    public String getMessage() {
        return "Ingrediente já cadastrado";
    }
}
