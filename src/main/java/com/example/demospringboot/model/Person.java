package com.example.demospringboot.model;

import lombok.Data;

@Data
public class Person {

    private final Long id;
    private final String name;
    private final Integer age;
    private final Integer temperature;
    private final Integer version;
    private final boolean isDelete;

}
