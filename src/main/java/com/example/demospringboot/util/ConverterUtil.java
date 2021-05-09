package com.example.demospringboot.util;

import com.example.demospringboot.dto.PersonDto;
import com.example.demospringboot.model.Person;

public class ConverterUtil {

    public static Person dtoToPerson(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getName(), personDto.getAge(), personDto.getTemperature(), 1, false);
    }

    public static PersonDto personToDto(Person person) {
        return new PersonDto(person.getId(), person.getName(), person.getAge(), person.getTemperature());
    }
}
