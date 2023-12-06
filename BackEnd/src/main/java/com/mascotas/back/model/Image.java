package com.mascotas.back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
