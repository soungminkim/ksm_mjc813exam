package com.mjc813.food_web.security;

import com.mjc813.food_web.common.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    public static final String idKeyName = "mjc813fw"; // 세션 쿠키 키 이름
    public static final String loginUserKey = "loginUser"; // 모델 속성 키

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer
                                .configurationSource(
                                        corsConfigurationSource())
                )
                .headers(
                    header ->
                    header
                        .frameOptions(
                            HeadersConfigurer.FrameOptionsConfig::sameOrigin
                        )
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((x) ->
                        x.requestMatchers("/").permitAll() //parmitAll은 로그인 없이 접속이 가능
                                        .requestMatchers("/signpage/**").permitAll()
                                        .requestMatchers("/main/**").permitAll()
                                        .requestMatchers("/cookiesign/**").permitAll()
                                        .requestMatchers("/sessionsign/**").permitAll()
                                        .requestMatchers("/springsign/**").permitAll()
                                        .requestMatchers("/bootswatch/**").permitAll()
                                        .requestMatchers("/error/**").permitAll()
                                // hasAuthority(ERole.ADMIN) ADMIN 권한이 필요함
                                        .requestMatchers("/food/**").hasAuthority(ERole.ADMIN.toString())
                                        .requestMatchers("/api/v1/food/**").hasAuthority(ERole.ADMIN.toString())
                                        .requestMatchers("/member/**").hasAuthority(ERole.ADMIN.toString())
                                        .requestMatchers("/api/v1/member/**").hasAuthority(ERole.ADMIN.toString())
                                        .anyRequest().authenticated()
                )
                // authenticated(): 나머지는 로그인이 필요함
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(daoAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                ;
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public DaoAuthTokenFilter daoAuthTokenFilter() {
        return new DaoAuthTokenFilter();
    }
}
