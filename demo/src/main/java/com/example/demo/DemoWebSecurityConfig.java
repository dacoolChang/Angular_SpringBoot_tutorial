package com.example.demo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.filter.CustomFilter;
import com.example.demo.filter.CustomFilter2;

@EnableWebSecurity
public class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable();
//        http
//        .authorizeRequests() // 啟用http驗証
//        	.anyRequest()	 // 所有request
//        	.authenticated() // 都要驗証過
//        .and()
//        .formLogin()
//        .and()
//        .httpBasic()
//        .and()
//        .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
//        .addFilterAfter(new CustomFilter2(), UsernamePasswordAuthenticationFilter.class);
        
    }

}
