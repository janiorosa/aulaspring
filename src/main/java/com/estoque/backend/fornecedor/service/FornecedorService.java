package com.estoque.backend.fornecedor.service;

import com.estoque.backend.fornecedor.entity.Fornecedor;
import com.estoque.backend.fornecedor.repository.FornecedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Fornecedor cadastrar(Fornecedor fornecedor) {
        // O ID é gerado pelo banco; não deve ser informado no cadastro.
        fornecedor.setIdFornecedor(null);

        return repository.save(fornecedor);
    }
}