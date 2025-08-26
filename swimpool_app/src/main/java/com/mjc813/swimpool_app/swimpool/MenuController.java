package com.mjc813.swimpool_app.swimpool;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/swimpool")
    public String swimpoolMenu(HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session) {

        Cookie ck = new Cookie("mycookie", "value");
        //ck.setHttpOnly(true);
        ck.setSecure(true);
        ck.setMaxAge(60 * 3 * 1 * 1); // 초 60 분 60 시 24 일 30 달 12 년
        ck.setPath("/");
        response.addCookie(ck);
        return "/swimpool/list";
    }
    @GetMapping("/make")
    public String make(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        Cookie ck = new Cookie("mycookie", "Teacher");
        //ck.setHttpOnly(true);
        ck.setSecure(true);
        ck.setMaxAge( 60 * 3 * 1 * 1 );
        ck.setPath("/");
        response.addCookie(ck);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        Cookie ck = new Cookie("mycookie", "");
        //ck.setHttpOnly(true);
        ck.setSecure(true);
        ck.setMaxAge( 0 );
        ck.setPath("/");
        response.addCookie(ck);
        return "redirect:/";
    }
}
