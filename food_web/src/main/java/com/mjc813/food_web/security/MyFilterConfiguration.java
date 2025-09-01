package com.mjc813.food_web.security;//package com.mjc813.food_web.security;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration(proxyBeanMethods = false)
//public class MyFilterConfiguration {
//    @Bean
//    public FilterRegistrationBean<DaoAuthTokenFilter> registration(DaoAuthTokenFilter daoAuthTokenFilter) {
//        FilterRegistrationBean<DaoAuthTokenFilter> registration = new FilterRegistrationBean<>(daoAuthTokenFilter);
//        registration.setEnabled(false);
//        return registration;
//    }
//    // SecurityFilterChain 에서 ignore permitall 한 필터는 처리 안하지만
//    // Servlet Filter 단에 빈으로 생성되는 커스텀(JwtAuthTokenFilter) 필터는 처리 한다.
//    // 그래서 위의 코드를 하면 Servlet Filter 단에서 커스텀필터는 처리하지 않는다
//}
