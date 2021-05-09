package com.example.demospringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private Integer age;
    private Integer temperature;

}
