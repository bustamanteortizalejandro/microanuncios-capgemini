package com.example.microanuncios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue
    private int id;

}
