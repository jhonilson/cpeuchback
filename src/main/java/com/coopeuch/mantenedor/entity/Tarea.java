package com.coopeuch.mantenedor.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;

    @Column(length = 200)
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @NotBlank(message = "La vigencia es obligatoria")
    private boolean vigente;
}

