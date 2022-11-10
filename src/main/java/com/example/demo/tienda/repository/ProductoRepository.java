package com.example.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.tienda.entities.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
