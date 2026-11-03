package com.portfolio.my_portfolio_backend.rest;

import com.portfolio.my_portfolio_backend.model.Education;
import com.portfolio.my_portfolio_backend.service.IEducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private final IEducationService educationService;

    public EducationController(IEducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public List<Education> getAllEducations() {
        return educationService.findAll();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id) {
        Optional<Education> info = educationService.findById(id);
        if (info.isPresent()) {
            return info.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Educación no disponible con el ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education newEducation = educationService.save(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Education update(@PathVariable Long id, @RequestBody Education education ) {
        education.setId(id);

        return educationService.save(education);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id ) {
        educationService.deleteById(id);
    }
}
