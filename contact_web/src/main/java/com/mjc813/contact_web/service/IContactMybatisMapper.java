package com.mjc813.contact_web.service;

import com.mjc813.contact_web.dto.Contact;
import com.mjc813.contact_web.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface IContactMybatisMapper {
    public void insert(Contact dto);
    public Contact selectOne(Long id);
    public void update(Contact dto);

    public Long countAll();
    public List<Contact> selectAll(PageDto pageDto);
}
