package com.example.tacoproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")

    private String name;
    // end::allButValidation[]

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    // tag::allButValidation[]
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void cerateAt()
    {
        this.createAt = new Date();
    }
}


