package com.example.demospringboot.repository;

import com.example.demospringboot.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    private List<Person> personList = new CopyOnWriteArrayList<>();
    private AtomicLong generator = new AtomicLong();

    @PostConstruct
    public void init() {
        personList.add(new Person(generator.incrementAndGet(), "Василий", 23, 37, 1, false));
    }

    public List<Person> findAll(){
        return personList.stream()
                .filter(it->!it.isDelete())
                .collect(Collectors.toUnmodifiableList());
    }

}
