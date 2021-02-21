package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDto;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDto;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 晁鹏飞
 * @since 2021-02-03
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;    //误报

    @Override
    public String register(UmsMemberRegisterParamDto umsMemberRegisterParamDto){
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDto,umsMember);
        String password= passwordEncoder.encode(umsMemberRegisterParamDto.getPassword());
        umsMember.setPassword(password);
        umsMemberMapper.insert(umsMember);
        return "success";
    }

    @Override
    public String login(UmsMemberLoginParamDto umsMemberLoginParamDto){
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDto.getUsername());
        if (null!=umsMember){
            String passwordDb = umsMember.getPassword();
            if (!passwordEncoder.matches(umsMemberLoginParamDto.getPassword(),passwordDb)){
                return "登录失败";
            }
        }else{
            return "登录失败";
        }
        System.out.println("登录成功");
        return "登录成功";
    }
}
