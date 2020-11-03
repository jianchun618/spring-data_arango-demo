package com.arangodb.spring.demo.service;

import com.arangodb.spring.demo.bean.Character;
import com.arangodb.spring.demo.bean.PageVo;
import com.arangodb.spring.demo.repository.CharacterVoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharactersVoServiceImpl implements   CharactersVoService{

    @Autowired
    CharacterVoRepository characterVoRepository;

    @Override
    public List<Character> getList(PageVo pageVo) {
        PageRequest of = PageRequest.of(pageVo.getPageNum() - 1, pageVo.getPageSize());
        Page<Character> characters = characterVoRepository.selectPage(of);
        for ( Character character : characters    ) {
            System.out.println(character);

        }

        return null;
    }
}
