package com.mascotas.back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "BLOB(10000000)") // Hasta 10MB
    private byte[] image;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
