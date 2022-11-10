package com.example.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.tienda.entities.Categoria;
@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer>{

}
