package com.dipak.smart.oven.controller;

import com.dipak.smart.oven.dto.recipe.Recipe;
import com.dipak.smart.oven.dto.recipe.RecipeV2;
import com.dipak.smart.oven.service.RecipesService;
import com.fasterxml.jackson.core.JsonParseException;
import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateoas.JsonError;

import java.util.List;
import java.util.Optional;

@Controller("/recipes")
public class RecipesController {

    private RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @Get
    @Version("1")
    public List<Recipe> getRecipes(@QueryValue Optional<String> query) {
        return recipesService.getRecipes(query);
    }

    @Get
    @Version("2")
    public List<RecipeV2> getRecipesV2(@QueryValue Optional<String> query) {
        return recipesService.getRecipesV2(query);
    }

    @Post
    public Recipe createRecipe(@Body Recipe recipe) {
        return recipesService.createRecipe(recipe);
    }

    @Put("/{recipeName}")
    public Recipe updateRecipe(String recipeName, @Body Recipe recipe) {
        return recipesService.updateRecipe(recipeName, recipe);
    }

    @Delete("/{recipeName}")
    public Recipe deleteRecipe(String recipeName) {
        return recipesService.deleteRecipe(recipeName);
    }

    @Error
    public HttpResponse<JsonError> jsonError(HttpRequest request, JsonParseException e) {
        JsonError error = new JsonError("Invalid JSON: " + e.getMessage());

        return HttpResponse.badRequest(error);
    }

    @Error(global = true, status = HttpStatus.NOT_FOUND)
    public HttpResponse<JsonError> notFound(HttpRequest request) {
        JsonError error = new JsonError("Something went wrong while trying to find the resource");

        return HttpResponse.notFound().body(error);
    }

}
