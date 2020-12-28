package com.example.tacoproject.Data;

import com.example.tacoproject.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {

    @Query("select t from Taco t where t.name = :name")
    public List<Taco> getTacosByName(@Param("name")String name);

    public List<Taco> findAll(Pageable page);
}
