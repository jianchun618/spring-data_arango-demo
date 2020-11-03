package com.arangodb.spring.demo.service;

import com.arangodb.spring.demo.entity.Character;
import com.arangodb.spring.demo.repository.CharacterRepository;
import com.arangodb.spring.demo.repository.CharacterVoRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CharacterServiceImpl implements  CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterVoRepository characterVoRepository;


    public int batchInsert(Set<Character> list) {

        Iterable<Character> result = characterRepository.saveAll(list);

        return  Iterables.size(result);
    }


}
