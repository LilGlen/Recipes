package com.LilGlen.Recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;
import com.LilGlen.Recipes.services.RecipeService;

@RestController
@RequestMapping("/receitas")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // Pesquisa receitas pelo nome
    @GetMapping("/searchByName")
    public ResponseEntity<List<Recipe>> findRecipesByName(@RequestParam String name) {
        List<Recipe> recipes = recipeService.findRecipesByName(name);
        return ResponseEntity.ok(recipes);
    }

    // Pesquisa receitas pelo ingrediente
    @GetMapping("/searchByIngredient")
    public ResponseEntity<List<Recipe>> findRecipesByIngredient(@RequestParam String ingredient) {
        List<Recipe> recipes = recipeService.findRecipesByIngredient(ingredient);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/searchByCategory")
    public ResponseEntity<List<Recipe>> findRecipesByCategory(@RequestParam RecipeCategory category) {
        List<Recipe> recipes = recipeService.findRecipesByCategory(category);
        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.create(recipe);
        return ResponseEntity.ok(newRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails) {
        Recipe updatedRecipe = recipeService.update(recipeDetails);
        return ResponseEntity.ok(updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
