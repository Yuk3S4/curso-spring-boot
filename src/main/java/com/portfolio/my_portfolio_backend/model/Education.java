package com.portfolio.my_portfolio_backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private Long id;

    @NotBlank(message = "El nombre del título no puede estar vacío")
    private String degree; // Ej: "Ingeniería en Sistemas"

    @NotBlank(message = "El nombre de la institución no puede estar vacío")
    private String institution; // Ej: "Universidad Nacional de Mar del Plata"

    @NotNull(message = "La fecha de inicio no debe ser nula")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate startDate;

    @PastOrPresent(message = "La fecha de fin no puede ser futura")
    private LocalDate endDate; // Puede ser null si está en curso

    @NotBlank(message = "La descripción de finalización no puede estar vacía")
    private String description; // Breve descripción de logros o cursos

    private Long personalInfoId; // Clave foránea a PersonalInfo
}
