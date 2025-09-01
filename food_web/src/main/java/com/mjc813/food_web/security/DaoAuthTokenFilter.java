package com.mjc813.food_web.security;

import com.mjc813.food_web.member.dto.MemberDto;
import com.mjc813.food_web.member.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class DaoAuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private MemberService memberService;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if (request.getMethod().equals("OPTIONS")) {
                filterChain.doFilter(request, response);
                return;
            }
            Object obj = request.getSession().getAttribute(WebSecurityConfig.idKeyName);
            if ( obj == null ) {
                filterChain.doFilter(request, response);
                return;
            }
            String userId = obj.toString();
            log.debug("DaoAuthTokenFilter.doFilterInternal userId : {}", userId);
            if (userId != null ) {
                MemberDto find = memberService.findById(Long.parseLong(userId));
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                find,
                                null,
                                find.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            log.error("Cannot set user authentication: {}", ex);
        }

        filterChain.doFilter(request, response);
    }
}
