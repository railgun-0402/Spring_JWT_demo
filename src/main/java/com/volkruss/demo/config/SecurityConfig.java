package com.volkruss.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers("/sample")
                );
        // 認証
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/api/login").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/api/**").authenticated()
        );
        http.addFilter(new JsonAuthenticationFilter(authentication -> authentication));

        // csrfを無効にしておく
        // またCookieを利用してcsrf対策を行う
        http.csrf((csrf) -> csrf
                .ignoringRequestMatchers("/api/**"));
        return http.build();
//        http.formLogin(
//                login -> login
//                .loginProcessingUrl("/login")
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
//                .permitAll()
//        ).logout(
//                logout -> logout
//                .logoutSuccessUrl("/")
//        ).authorizeHttpRequests(authz -> authz
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/general").hasRole("GENERAL")
//                .requestMatchers("./admin").hasRole("ADMIN")
//                .anyRequest().authenticated()
//        );
//        return http.build();
    }
}
