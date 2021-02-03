package com.msb.dongbao.ums.mapper;

import com.msb.dongbao.ums.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author bask
 * @Description TODO
 * @date 2021年02月02日 19:55
 */
@MapperScan("com.msb.dongbao.ums.mapper")
@SpringBootTest
public class UmsMemberTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
    void testInsert(){
        UmsMember t = new UmsMember();
        t.setId(1L);
        t.setNickName("nick");
        t.setNote("note");
        umsMemberMapper.insert(t);
    }

}
