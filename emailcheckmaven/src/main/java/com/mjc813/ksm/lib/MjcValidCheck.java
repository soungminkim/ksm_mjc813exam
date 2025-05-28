package com.mjc813.ksm.lib;

public class MjcValidCheck {
    public boolean isValidPhoneNumber(String text){
        if(text == null){
            return false;
        }
        String Number = "^010-[0-9]{4}-[0-9]{4}$";
        return text.matches(Number);
    }
    public boolean isValidZipNumber(String text){
        if(text == null){
            return false;
        }
        String Number = "^[1-9]{5}$";
        return text.matches(Number);
    }
    public boolean isValidEmail(String text){
        if(text == null){
            return false;
        }
        String Email = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return text.matches(Email);
    }
}
