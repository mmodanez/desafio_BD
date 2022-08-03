package com.totalshakes.wstotalshakes;

import com.totalshakes.wstotalshakes.controller.IngredienteCrontoller;
import com.totalshakes.wstotalshakes.exception.IngredienteCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WstotalshakesApplicationTests {

    @Autowired
    IngredienteCrontoller ingredienteController;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveIngredienteFuncionaCorretamente() throws IngredienteCadastradoException {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome("Morango");

        ResponseEntity ingredienteSalvo = ingredienteController.saveIngrediente(ingrediente);
        assertEquals(HttpStatus.CREATED, ingredienteSalvo.getStatusCode());
    }

    @Test
    void testFindIngredienteByIdFuncionaCorretamente() throws IngredienteNaoEncontradoException {
        int id = 3;

        ResponseEntity ingredienteEncontrado = ingredienteController.findIngredienteById(id);
        assertEquals(HttpStatus.OK, ingredienteEncontrado.getStatusCode());
    }

    @Test
    void testUpdateIngredienteFuncionaCorretamente() throws IngredienteNaoEncontradoException {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome("Manga");
        ingrediente.setId(3);

        ResponseEntity ingredienteAtualizado = ingredienteController.updateIngrediente(ingrediente.getId(),
                ingrediente.getNome());
        assertEquals(HttpStatus.OK, ingredienteAtualizado.getStatusCode());
    }

    @Test
    void testDeleteIngredienteByIdFuncionaCorretamente() throws IngredienteNaoEncontradoException {
        int id = 3;
        ResponseEntity ingredienteExcluido = ingredienteController.deleteIngredienteById(id);
        assertEquals(HttpStatus.OK, ingredienteExcluido.getStatusCode());
    }
}
