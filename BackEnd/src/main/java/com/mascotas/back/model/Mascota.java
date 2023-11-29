/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mascotas.back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "mascotas")
public class Mascota {
   @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long mascotaId;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "raza")
    private String raza;
    
    @Column(name = "edad")
    private Integer edad;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private String estado;

   @ManyToOne(targetEntity = Usuario.class)
   @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
