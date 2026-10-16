package com.estoque.backend.fornecedor.controller;

import com.estoque.backend.fornecedor.entity.Fornecedor;
import com.estoque.backend.fornecedor.service.FornecedorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    // GET: listar todos os fornecedores
    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // POST: cadastrar um novo fornecedor
    @PostMapping
    public ResponseEntity<Fornecedor> cadastrar(
            @RequestBody Fornecedor fornecedor) {

        Fornecedor novo = service.cadastrar(fornecedor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novo);
    }
}