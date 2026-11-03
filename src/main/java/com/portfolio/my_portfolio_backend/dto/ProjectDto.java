package com.portfolio.my_portfolio_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
public class ProjectDto {
    private Long id;

    @NotBlank(message = "El título no puede estar vacío.")
    @Size(min = 2, max = 255, message = "El título debe tener entre 2 y 255 caracteres.")
    private String title;

    @NotBlank(message = "La descripción no puede estar vacía.")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres.")
    private String description;

    @URL(message = "La url de la imágen no tiene un formato válido.")
    private String imageUrl; // URL o ruta a la imagen del proyecto

    @URL(message = "La url del proyecto no tiene un formato válido.")
    private String projectUrl; // URL al proyecto desplegado (si existe) o GitHub

    @NotBlank(message = "El ID de información personal no puede ser nulo.")
    @Min(value = 1, message = "El ID de información personal debe ser un número positivo.")
    private Long personalInfoId; // Clave foránea a PersonalInfo
}
