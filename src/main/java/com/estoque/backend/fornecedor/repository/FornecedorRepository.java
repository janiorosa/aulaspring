package com.estoque.backend.fornecedor.repository;

import com.estoque.backend.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository
        extends JpaRepository<Fornecedor, Integer> {
}