package com.mjc813.contactjsp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto implements IContact {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String zipNumber;
    private String email;

    @Override
    public String getContactFullInfo() {
            return "ID: " + id + "\n"
                    + "이름: " + name + "\n"
                    + "전화번호: " + phoneNumber + "\n"
                    + "집전화번호" + zipNumber + "\n"
                    + "이메일: " + email;
    }
}
