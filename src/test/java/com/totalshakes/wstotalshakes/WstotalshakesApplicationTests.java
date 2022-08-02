package com.totalshakes.wstotalshakes;

import com.totalshakes.wstotalshakes.controller.IngredienteCrontoller;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WstotalshakesApplicationTests {

    @Autowired
    IngredienteCrontoller ingredienteController;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveIngredienteFuncionaCorretamente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome("Morango");

        ResponseEntity ingredienteSalvo = ingredienteController.saveIngrediente(ingrediente);
        assertEquals(HttpStatus.CREATED, ingredienteSalvo.getStatusCode());
    }

    //implementar esse teste com o método de getAllIngredientes
    @Test
    void testFindIngredienteByIdFuncionaCorretamente() {
        int id = 3;

        ResponseEntity ingredienteEncontrado = ingredienteController.findIngredienteById(id);
        assertEquals(HttpStatus.OK, ingredienteEncontrado.getStatusCode());
    }

    @Test
    void testUpdateIngredienteFuncionaCorretamente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome("Manga");
        ingrediente.setId(3);

        ResponseEntity ingredienteAtualizado = ingredienteController.updateIngrediente(ingrediente.getId(),
                ingrediente.getNome());
        assertEquals(HttpStatus.OK, ingredienteAtualizado.getStatusCode());
    }

    @Test
    void testDeleteIngredienteByIdFuncionaCorretamente() {
        int id = 2;
        ResponseEntity ingredienteExcluido = ingredienteController.deleteIngredienteById(id);
        assertEquals(HttpStatus.OK, ingredienteExcluido.getStatusCode());
    }
}
