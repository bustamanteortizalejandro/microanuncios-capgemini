package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AnuncioService anuncioService;

    @Override
    public List<Categoria> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoriaDTO> findAllDTO() {
        List<Categoria> categorias= categoryRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for(Categoria categoria: categorias){
                   categoriaDTOS.add(parseCategoria(categoria));
        }
        return categoriaDTOS;

    }

    @Override
    public Optional<Categoria> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoriaDTO findByIdDTO(int id) {
        Categoria categoria = findById(id).get();
        if(categoria ==null){
            throw new IllegalArgumentException("El objeto no puede ser nulo");
        }
        CategoriaDTO categoriaDTO = parseCategoria(categoria);
        return categoriaDTO;

    }

    @Override
    public void Save(Categoria categoria) {
        categoryRepository.save(categoria);
    }

    @Override
    public CategoriaDTO update(CategoriaDTO categoriaDTO) {
        if (categoryRepository.findById(categoriaDTO.getId()).isPresent()) {
            Categoria udpateCategoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(udpateCategoria);
            return parseCategoria(udpateCategoria);
        } else {
            throw new IllegalArgumentException("La categoria no existe");
        }
    }

    @Override
    public Categoria parseCategoriaDTO(CategoriaDTO categoriaDTO) {

        if (categoriaDTO.getDescripcion() != null) {
            Categoria categoria = new Categoria(
                    categoriaDTO.getId(),
                    categoriaDTO.getDescripcion()
            );
            return categoria;
        } else {
            throw new IllegalArgumentException("El objeto CategoriaDTO no puede ser nulo");
        }
    }

    @Override
    public CategoriaDTO parseCategoria(Categoria categoria) {

        CategoriaDTO categoriaDTO = new CategoriaDTO(
                categoria.getId(),
                categoria.getDescripcion()
        );

        return categoriaDTO;
    }

    @Override
    public CategoriaDTO saveNewCategoria(CategoriaDTO categoriaDTO) {

        List<Categoria> categories = categoryRepository.findAll();

        int maxId = categories.stream()
                .mapToInt(value -> value.getId()).max().getAsInt()+1;

            categoriaDTO.setId(maxId);
            Categoria categoria = parseCategoriaDTO(categoriaDTO);
            categoryRepository.save(categoria);
            return parseCategoria(categoria);


    }

    @Override
    public ResponseEntity<String> deleteById(int id) {


        try{
            Optional<Categoria> categoria = categoryRepository.findById(id);

            if (!categoria.isPresent()) {
                throw new IllegalArgumentException("Está categoria no existe");
            }

            if(!categoria.get().getAnuncios().isEmpty()){
                throw new IllegalStateException("La categoría contiene anuncios y no se puede borrar");
            }

            anuncioService.deleteAllByCategoriaId(id);

            categoryRepository.deleteById(id);

            return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);

        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (IllegalStateException  e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error inesperado al eliminar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
}
