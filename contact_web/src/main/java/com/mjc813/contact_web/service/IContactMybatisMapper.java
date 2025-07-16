package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.Contact;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface IContactMybatisMapper {
    public void insert(Contact dto);
    public List<Contact> selectAll();
}
