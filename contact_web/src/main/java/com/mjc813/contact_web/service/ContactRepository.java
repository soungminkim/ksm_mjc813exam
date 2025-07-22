package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.Contact;
import com.mjc813.contact_web.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactRepository {
    @Autowired
    private IContactMybatisMapper mapper;
    public Contact insert(Contact item) {mapper.insert(item); return item; }
    public Contact selectOne(Long id) {return this.mapper.selectOne(id); }
    public void update(Contact dto) {this.mapper.update(dto);}

    public Long acountAll() {return this.mapper.countAll();}
    public java.util.List<Contact> selectAll(PageDto pageDto) {
        return this.mapper.selectAll(pageDto);
    }

}
