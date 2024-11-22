package com.LilGlen.Recipes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

     List<Recipe> findByIngredientsContaining(String ingredients);

     List<Recipe> findByName(String name);

     Optional<Recipe> findByNameAndAuthor(String name, String Author);

     List<Recipe> findByCategory(RecipeCategory category);
}
