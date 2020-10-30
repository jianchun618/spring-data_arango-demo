package com.arangodb.spring.demo.controller;

import com.arangodb.spring.demo.entity.Character;
import com.arangodb.spring.demo.service.AqlService;
import com.arangodb.spring.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class CharacterController {

  @Autowired
    private CharacterService characterService;

  @Autowired
  private AqlService aqlService;

  @RequestMapping("/test")
  @ResponseBody
  public  Integer create(){

      Character character = new Character("123", "zhangsan", "wang", true, 10);
      Character character2 = new Character("12345", "lisi", "wang", true, 10);
      Set<Character> objects = new HashSet<>();
      objects.add(character );
      objects.add(character2);

      int i = characterService.batchInsert(objects);
   return  i;
  }

  @RequestMapping("/testAql")
  @ResponseBody
    public  String  result(){
      aqlService.getList();
      return "success";
  }

}
