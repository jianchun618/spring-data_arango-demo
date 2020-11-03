package com.arangodb.spring.demo.service;

import com.arangodb.spring.demo.bean.Character;
import com.arangodb.spring.demo.bean.PageVo;

import java.util.List;

public interface CharactersVoService {

    List<Character> getList(PageVo pageVo);
}
