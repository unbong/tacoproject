package com.example.tacoproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.tacoproject.Data.IngredientRepository;
import com.example.tacoproject.Data.TacoRepository;
import com.example.tacoproject.Ingredient.Type;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
//@Controller
@RestController
@RequestMapping(value = "/design", produces = "application/json")
@SessionAttributes(names = "order")
public class DesignTacoController {

    private final IngredientRepository _ingredietRepo;
    private final TacoRepository _tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository  ingredientRepo, TacoRepository tacoRepo)
    {
        this._ingredietRepo = ingredientRepo;
        this._tacoRepo = tacoRepo;
    }

//    @GetMapping("recent")
//    public Iterable<Taco> recentTacos()
//    {
//
//        PageRequest page = PageRequest.of(0,12, Sort.by("createAt").descending());
//
//        return _tacoRepo.findAll(page);
//    }

        @GetMapping("recent")
        public CollectionModel<EntityModel<Taco>> recentTaco()
        {
            Pageable page = PageRequest.of(0,11);
            List<Taco> tacos = _tacoRepo.findAll(page);
            CollectionModel<EntityModel<Taco>> recentResources = CollectionModel.wrap(tacos);

            recentResources.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DesignTacoController.class).recentTaco()).withRel("recents"));
            return recentResources;

        }
//    @GetMapping("/{id}")
//    public Taco tacoByid(@PathVariable Long id)
//    {
//        Optional<Taco> tacoOpt =  _tacoRepo.findById(id);
//        if(tacoOpt.isPresent())
//        {
//            return tacoOpt.get();
//        }
//
//        return null;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoByid(@PathVariable("id") Long id )
    {
       Optional<Taco> tacoOpt = _tacoRepo.findById(id);
       if(tacoOpt.isPresent())
       {
           return new ResponseEntity<>(tacoOpt.get(), HttpStatus.OK);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco genTaco (@RequestBody Taco taco)
    {
        return _tacoRepo.save(taco);
    }

//    @ModelAttribute(name = "order")
//    public Order order()
//    {
//        return new Order();
//    }
//
//    @ModelAttribute(name = "design")
//    public Taco design()
//    { return new Taco();}
//
//    @GetMapping
//    public String showDesignForm(Model mode)
//    {
//        List<Ingredient> ingredients = new ArrayList<>();
//         _ingredietRepo.findAll().forEach((x) ->  ingredients.add(x));
//
//        Type[] types = Ingredient.Type.values();
//
//        for(Type t : types) {
//            mode.addAttribute(t.toString().toLowerCase(), filterByType(ingredients, t));
//        }
//
//        return "design";
//    }
//
//    @PostMapping
//    public String processDesign(@Valid Taco desigN, Errors error, @ModelAttribute Order order)
//    {
//        if(error.hasErrors())
//        {
//            return "design";
//        }
//
//        log.info("processing design; " + desigN);
//        Taco res = _tacoRepo.save(desigN);
//        order.addDesign(res);
//
//        List<Taco>  tacos=  _tacoRepo.getTacosByName("piaomeilin1991@gmail.com");
//
//        if (tacos.isEmpty()) log.error("is empty");
//        else log.error("not empty");
//
//        return "redirect:/orders/current";
//    }
//
//
//    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type)
//    {
//        return ingredients.stream()
//                .filter(x -> x.getType().equals(type))
//                .collect(Collectors.toList());
//
//    }

}


