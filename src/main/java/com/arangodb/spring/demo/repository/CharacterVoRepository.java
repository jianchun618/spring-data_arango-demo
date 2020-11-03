package com.arangodb.spring.demo.repository;

import com.arangodb.spring.demo.bean.Character;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface  CharacterVoRepository extends ArangoRepository<Character, String> {
    @Query("for i in Characters   #pageable return i")
    Page<Character> selectPage(Pageable pageable);
}
