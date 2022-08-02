package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServiceImplementation implements IngredienteService {

    private IngredienteRepository ingredienteRepository;

    public IngredienteServiceImplementation(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        if (ingredienteRepository.findById(ingrediente.getId()).isPresent())
            throw new IllegalArgumentException("Ingrediente já cadastrado");
        else
            ingredienteRepository.save(ingrediente);
    }

    @Override
    public Ingrediente findIngredienteById(int id) {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("Ingrediente não encontrado");
        else
            return ingredienteRepository.findById(id).get();
    }

    @Override
    public void updateIngrediente(int id, String ingrediente) {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("Ingrediente não encontrado");
        else {
            Ingrediente ingredienteEncontrado = ingredienteRepository.findById(id).get();
            ingredienteEncontrado.setNome(String.valueOf(ingrediente));
            ingredienteRepository.save(ingredienteEncontrado);
        }
    }

    @Override
    public void deleteIngredienteById(int id) {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("Ingrediente não encontrado");
        else
            ingredienteRepository.deleteById(id);
    }
}
