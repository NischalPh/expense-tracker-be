package com.nischal.expensetracker.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nischal.expensetracker.common.builder.ResponseBuilder;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.filter.AuthTokenFilter;
import com.nischal.expensetracker.common.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author : Nischal on 7/25/2024
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public WebSecurityConfig(UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(((req, res, authException) -> {
                    res.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    Response response = ResponseBuilder.failure("Authorization failedd");
                    //LogUtil.exception(authException.getMessage());
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.writeValue(res.getOutputStream(), response);
                }))
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterBefore(getAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public AuthTokenFilter getAuthTokenFilter() {
        return new AuthTokenFilter(jwtUtil, userDetailsService);
    }
}
