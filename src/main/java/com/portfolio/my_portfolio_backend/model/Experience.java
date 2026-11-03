package com.portfolio.my_portfolio_backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    private Long id;

    @NotBlank(message = "El título del puesto no puede estar vacío")
    private String jobTitle; // Ej: "Full Stack Developer"

    @NotBlank(message = "El nombre de la compañía no puede estar vacío")
    private String companyName;

    @NotNull(message = "La fecha de inicio no debe ser nula")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate startDate;

    @PastOrPresent(message = "La fecha de fin no puede ser futura")
    private LocalDate endDate; // Puede ser null si es el puesto actual

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description; // Responsabilidades y logros

    private Long personalInfoId; // Clave foránea a PersonalInfo
}
