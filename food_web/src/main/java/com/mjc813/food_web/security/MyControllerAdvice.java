package com.mjc813.food_web.security;//package com.mjc813.food_web.security;
//
//import com.mjc813.food_web.member.dto.MemberDto;
//import com.mjc813.food_web.member.service.MemberService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
//import java.util.Arrays;
//
//@ControllerAdvice
//public class MyControllerAdvice {
//    @Autowired
//    private MemberService memberService;
//
//    private final String[] authUrls = new String[]{
//            "/api"
//            , "/root"
//            , "/food_category"
//            , "/ingredient_category"
//            , "/ingredient"
//            , "/food"
//            , "/member"
//    };
//
//    @ModelAttribute
//    public void addModel(HttpServletRequest request, Model model
////            , @CookieValue(name = WebSecurityConfig.idKeyName, required = false) String idStr
//            , @SessionAttribute(name = WebSecurityConfig.idKeyName, required = false) String idStr
//    ) {
//        String url = request.getRequestURI();
//        String authUrl = Arrays.stream(this.authUrls)
//                .filter(item -> url.contains(item))
//                .findAny().orElse(null);
//        if( authUrl != null && idStr != null ) {
//            Long id = Long.parseLong(idStr);
//            MemberDto find = this.memberService.findById(id);
//            model.addAttribute(WebSecurityConfig.loginUserKey, find);
//        }
//    }
//}
