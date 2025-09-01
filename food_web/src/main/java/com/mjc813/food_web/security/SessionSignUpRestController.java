package com.mjc813.food_web.security;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.common.exception.MyDataNotFoundException;
import com.mjc813.food_web.common.exception.MyRequestException;
import com.mjc813.food_web.member.dto.IMember;
import com.mjc813.food_web.member.dto.MemberDto;
import com.mjc813.food_web.member.service.MemberService;
import com.mjc813.food_web.security.dto.SignInRequestDto;
import com.mjc813.food_web.security.dto.SignUpRequestDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sessionsign")
public class SessionSignUpRestController extends CommonRestController { // 세션방식 로그인

    @Autowired
    private MemberService memberService;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(
            @Validated @RequestBody SignUpRequestDto requestDto
            ) {
        try {
            MemberDto memberDto = new MemberDto();
            memberDto.copyMembersNotNull(requestDto);
            IMember iMember = this.memberService.insert(memberDto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iMember, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), requestDto, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", requestDto, th);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDto> signin(
            @Validated @RequestBody SignInRequestDto requestDto
            , HttpSession httpSession
            , HttpServletResponse response
    ) {
        try {
            IMember iMember = this.memberService.findByUsername(requestDto.getUsername());
            if ( !encoder.matches(requestDto.getPassword(), iMember.getPassword()) ) {
            //if ( !requestDto.getPasswd().equals( iMember.getPasswd() ) ) {
                MyDataNotFoundException md = new MyDataNotFoundException("login failed");
                return this.getReponseEntity(ResponseCode.SIGNIN_FAIL, md.getMessage(), requestDto, md);
            }
//            Cookie cookie = new Cookie(WebSecurityConfig.idKeyName, iMember.getId().toString());
//            cookie.setMaxAge(60 * 60 * 24);
//            cookie.setSecure(true);
//            cookie.setPath("/");
//            response.addCookie(cookie);
            // 세션에 사용자 ID 저장
            httpSession.setAttribute(WebSecurityConfig.idKeyName, iMember.getId().toString());
            httpSession.setMaxInactiveInterval( 60 * 60 * 3 * 1 );
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iMember, null);
        } catch (MyRequestException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.REQUEST_FAIL, e.getMessage(), requestDto, e);
        } catch (MyDataNotFoundException e) {
            log.error(e.toString());
            return this.getReponseEntity(ResponseCode.SIGNIN_FAIL, e.getMessage(), requestDto, e);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", requestDto, th);
        }
    }

    @PostMapping("/signout")
    private ResponseEntity<ResponseDto> signout(HttpSession httpSession) {
//        Cookie cookie = new Cookie(WebSecurityConfig.idKeyName, null);
//        cookie.setMaxAge(0);
//        cookie.setSecure(true);
//        cookie.setPath("/");
//        response.addCookie(cookie);
        httpSession.invalidate();
        return this.getReponseEntity(ResponseCode.SUCCESS, "OK", null, null);
    }
}
