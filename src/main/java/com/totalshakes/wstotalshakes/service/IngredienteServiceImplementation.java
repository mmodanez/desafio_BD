package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.exception.IngredienteCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
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
    public void saveIngrediente(Ingrediente ingrediente) throws IngredienteCadastradoException {
        if (ingredienteRepository.findById(ingrediente.getId()).isPresent())
            throw new IngredienteCadastradoException();
        else
            ingredienteRepository.save(ingrediente);
    }

    @Override
    public Ingrediente findIngredienteById(int id) throws IngredienteNaoEncontradoException {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IngredienteNaoEncontradoException();
        else
            return ingredienteRepository.findById(id).get();
    }

    @Override
    public void updateIngrediente(int id, String ingrediente) throws IngredienteNaoEncontradoException {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IngredienteNaoEncontradoException();
        else {
            Ingrediente ingredienteEncontrado = ingredienteRepository.findById(id).get();
            ingredienteEncontrado.setNome(String.valueOf(ingrediente));
            ingredienteRepository.save(ingredienteEncontrado);
        }
    }

    @Override
    public void deleteIngredienteById(int id) throws IngredienteNaoEncontradoException  {
        if (ingredienteRepository.findById(id).isEmpty())
            throw new IngredienteNaoEncontradoException();
        else
            ingredienteRepository.deleteById(id);
    }
}
