package com.example.demospringboot.service;

import com.example.demospringboot.dto.PersonDto;
import com.example.demospringboot.repository.PersonRepository;
import com.example.demospringboot.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream().map(ConverterUtil::personToDto).collect(Collectors.toUnmodifiableList());
    }
}
