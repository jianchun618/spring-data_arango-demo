package com.arangodb.spring.demo.bean;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Field;
import com.arangodb.springframework.annotation.HashIndex;

import java.util.List;
import java.util.Map;

@Document("Characters")
@HashIndex(fields = { "name", "surname" }, unique = true)
public class Character {

    @Field("name")
    private  String name;

    private  String surname;

    private  boolean alive;

    private List<String> traits;

    private Map<String,Object> content;



}