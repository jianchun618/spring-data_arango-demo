package com.arangodb.spring.demo.controller;

import com.arangodb.spring.demo.bean.PageVo;
import com.arangodb.spring.demo.entity.Character;
import com.arangodb.spring.demo.service.AqlService;
import com.arangodb.spring.demo.service.CharacterService;
import com.arangodb.spring.demo.service.CharactersVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/one")
public class CharacterController {

  @Autowired
    private CharacterService characterService;

  @Autowired
  private CharactersVoService charactersVoService;

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


  @RequestMapping("/pageSelect")
  @ResponseBody
    public  String  selectPage(@RequestBody PageVo pageVo){

     // PageVo pageVo = new PageVo(pageNum, pafeSize);
      List<com.arangodb.spring.demo.bean.Character> list = charactersVoService.getList(pageVo);
      return  "success";
  }

  @RequestMapping("two")
  @ResponseBody
    public  String  testPath(){

      return  "success";
  }
}
