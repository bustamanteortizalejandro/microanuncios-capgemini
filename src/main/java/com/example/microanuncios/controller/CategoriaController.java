package com.example.microanuncios.controller;

import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> categoriasDTO = categoriaService.findAllDTO();
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable("categoriaId") int categoriaId) {
        CategoriaDTO categoriaDTO = categoriaService.findByIdDTO(categoriaId);

        if (categoriaDTO != null) {
            return ResponseEntity.ok(categoriaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/categorias/update")
    public ResponseEntity<CategoriaDTO> updateCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        if (categoriaDTO != null) {
            CategoriaDTO categoriaDTOupdated = categoriaService.update(categoriaDTO);
            return ResponseEntity.ok(categoriaDTOupdated);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/categorias/save")
    public ResponseEntity<CategoriaDTO> saveNewCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        if (categoriaDTO.getDescripcion() != null) {
            CategoriaDTO categoriaSaved = categoriaService.saveNewCategoria(categoriaDTO);
            return ResponseEntity.ok(categoriaSaved);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("/categorias/delete/{categoriaId}")
    public ResponseEntity<String> deleteCategoria(@PathVariable("categoriaId") int categoriaId) {

        if (categoriaService.deleteById(categoriaId)) {
            return new ResponseEntity<>("categoria eliminada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha podido eliminar la categoria", HttpStatus.BAD_REQUEST);
        }
    }
}
