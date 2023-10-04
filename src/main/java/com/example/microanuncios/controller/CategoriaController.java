package com.example.microanuncios.controller;

import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/microanuncios")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<Categoria> findById(@PathVariable("categoriaId") int categoriaId) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(categoriaId);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/categorias/update")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        if (categoriaDTO != null) {
            Categoria categoria = categoriaService.update(categoriaDTO);
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/categorias/save")
    public ResponseEntity<Categoria> saveNewCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        if (categoriaDTO != null) {
            Categoria categoria = categoriaService.saveNewCategoria(categoriaDTO);
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}
