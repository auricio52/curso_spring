package com.empresa.course.controllers;

import com.empresa.course.entities.Category;
import com.empresa.course.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }
}
