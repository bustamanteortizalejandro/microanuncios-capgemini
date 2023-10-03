package com.example.microanuncios.controller;

import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AnuncioController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/lista")
    public ResponseEntity <List<Categoria>> getAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/anunciouno")
    public ResponseEntity<Categoria> getUno() {
        Optional<Categoria> categoriaOptional = categoriaService.findById(1);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            return ResponseEntity.ok(categoria);
        } else {
            // En este caso, no se encontró una categoría con el ID proporcionado (0).
            return ResponseEntity.notFound().build();
        }
    }

}
