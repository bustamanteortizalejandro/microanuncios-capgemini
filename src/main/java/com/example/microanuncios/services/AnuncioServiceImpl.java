package com.example.microanuncios.services;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.model.Anuncio;

import com.example.microanuncios.repository.AnuncioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnuncioServiceImpl implements AnuncioService {


    private AnuncioRepository anuncioRepository;
    @Override
    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public Optional<Anuncio> findById(int id) {
        return anuncioRepository.findById(id);
    }

    @Override
    public void Save(Anuncio anuncio) {
        anuncioRepository.save(anuncio);
    }

    @Override
    public Anuncio update(AnuncioDTO anuncioDTO) {

        Anuncio anuncioUpdated = new Anuncio(
                anuncioDTO.getId_anuncio(),
                anuncioDTO.getUser(),
                anuncioDTO.getTitulo(),
                anuncioDTO.getDescripcion(),
                anuncioDTO.getPrecio(),
                anuncioDTO.getFecha_publicacion(),
                anuncioDTO.getUsuario()
        );
        anuncioRepository.save(anuncioUpdated);
        return anuncioUpdated;

    }
}
