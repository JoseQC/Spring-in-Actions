package com.example.tacocloud.tacos.controller;

import com.example.tacocloud.tacos.entity.Ingredient;
import com.example.tacocloud.tacos.entity.Ingredient.Type;
import com.example.tacocloud.tacos.repositoryjdbc.IngredientRepository;
import com.example.tacocloud.tacos.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type: types){
            model.addAttribute(
                    type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients,type)
            );
        }

    }

    /*
        @ModelAttribute
        public void addIngredientsToModel(Model model) {
            List<Ingredient> ingredients = Arrays.asList(
                    new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                    new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                    new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                    new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                    new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                    new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                    new Ingredient("CHED", "Cheddar", Type.CHEESE),
                    new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                    new Ingredient("SLSA", "Salsa", Type.SAUCE),
                    new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
            );

            Type[] types = Ingredient.Type.values();
            for (Type type : types) {
                model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
            }

        }
    */
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors) {
        if (errors.hasErrors())
            return "design";
        //Save the taco...
        //We'll do this in chapter 3
        log.info("Processing taco:" + taco);
        return "redirect:/orders/current";
    }
}
