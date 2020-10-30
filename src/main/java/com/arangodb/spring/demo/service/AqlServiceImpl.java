package com.arangodb.spring.demo.service;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.core.ArangoOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.arangodb.spring.demo.bean.Character;
import java.util.List;

/**
 * 测试 拼接aql，根据条件查询记录的内部内容
 */

@Service
public class AqlServiceImpl implements  AqlService {

    @Autowired
    private ArangoOperations arangoOperations;


    public  String  getList(){
       /* for ci in Characters
        filter ci.content['ci_name']=='first'
        return ci
       */
        String aql=String.format("FOR ci in  Characters  filter ci.content['%s']=='%s'  sort ci.update_time desc limit %d,%d return ci   ","ci_name","first",0,10);
        ArangoCursor<Character> query = arangoOperations.query(aql, Character.class);
        List<Character> characters = query.asListRemaining();
        characters.forEach(s-> System.out.println(s));
        return  "success";
    }

}
