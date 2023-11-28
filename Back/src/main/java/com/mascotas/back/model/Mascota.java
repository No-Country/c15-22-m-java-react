/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mascota")
@Getter
@Setter
public class Mascota {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long mascotaId;
    
    private String nombre;
    private String descripcion;
    private String tipo;

    public Mascota() {
    }

    public Mascota(Long mascotaId, String nombre, String descripcion, String tipo) {
        this.mascotaId = mascotaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    
    
    
}
