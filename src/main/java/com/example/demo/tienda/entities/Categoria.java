package com.example.demo.tienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Categoria {
	@Id
	@SequenceGenerator(name="categoria_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="categoria_id_seq")
	private Integer id;
	
	private String descripcion;

}
