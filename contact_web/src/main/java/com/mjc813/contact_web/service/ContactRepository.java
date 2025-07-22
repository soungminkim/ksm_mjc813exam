package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactRepository {
    @Autowired
    private IContactMybatisMapper mapper;

    public Contact insert(Contact item) {
        mapper.insert(item);
        return item;
    }

    public java.util.List<Contact> selectAll() {
        return mapper.selectAll();
    }

    public Contact selectOne(Long id) {return this.mapper.selectOne(id); }

    public void update(Contact dto) {this.mapper.update(dto);}
}
