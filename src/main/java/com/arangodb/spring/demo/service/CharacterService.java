package com.arangodb.spring.demo.service;

import com.arangodb.spring.demo.entity.Character;

import java.util.Set;

public interface CharacterService {

    int batchInsert(Set <Character> list);


}
