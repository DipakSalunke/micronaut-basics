package com.dipak.smart.oven.service;

import com.dipak.smart.oven.dto.recipe.Recipe;
import com.dipak.smart.oven.dto.recipe.RecipeV2;
import com.dipak.smart.oven.exception.InvalidTemperatureException;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Singleton
public class RecipesService {

    private static List<Recipe> recipes = new ArrayList<>(List.of(
            new Recipe("pizza", 475, 900),
            new Recipe("chicken", 450, 900),
            new Recipe("salmon", 375, 1200)));

    public List<Recipe> getRecipes(Optional<String> query) {
        return recipes.stream()
                .filter(recipe -> !query.isPresent() || query.get().equalsIgnoreCase(recipe.getName()))
                .collect(toList());
    }

    public List<RecipeV2> getRecipesV2(Optional<String> query) {
        return recipes.stream()
                .filter(recipe -> !query.isPresent() || query.get().equalsIgnoreCase(recipe.getName()))
                .map(recipe -> new RecipeV2(recipe.getName(), recipe.getCookingTemperature(), recipe.getCookingDuration()))
                .collect(toList());
    }

    public Recipe createRecipe(Recipe recipe) {
        if(recipe.getCookingTemperature() > 600 ) {
            throw new InvalidTemperatureException("Invalid temperature: " + recipe.getCookingTemperature() );
        }
        recipes.add(recipe);
        return recipe;
    }

    public Recipe updateRecipe(String recipeName, Recipe recipe) {
        recipes.removeIf(rec -> rec.getName().equalsIgnoreCase(recipeName));
        recipes.add(recipe);
        return recipe;
    }

    public Recipe deleteRecipe(String recipeName) {
        Recipe recipe = recipes.stream()
                .filter(rec -> rec.getName().equalsIgnoreCase(recipeName))
                .findFirst()
                .get();
        recipes.remove(recipe);
        return recipe;
    }
}
