package com.example.microanuncios.repository;

import com.example.microanuncios.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categoria, Integer> {
}
