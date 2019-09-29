// package com.lunz.cpfw.web.config;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//     @Value("${spring.secruity.oauth2.resourceserver.jwt.jwk-set-uri}")
//     private String jwkSetUri;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests().antMatchers("/swagger-ui.html**").permitAll().antMatchers("/webjars/**").permitAll()
//                 .antMatchers("/swagger-resources/**").permitAll()
//                 // .antMatchers("/csrf").permitAll()
//                 .antMatchers("/*").permitAll()
//                 // .antMatchers("/manage/health").permitAll()
//                 .antMatchers("/api/v1/**").permitAll().antMatchers("/v2/api-docs").permitAll().anyRequest()
//                 .authenticated().and().logout().permitAll().and().oauth2ResourceServer().jwt();
//     }

//     @Bean
//     public JwtDecoder jwtDecoder() {
//         return new NimbusJwtDecoderJwkSupport(jwkSetUri);
//     }
// }