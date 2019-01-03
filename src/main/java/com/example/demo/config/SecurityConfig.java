package com.example.demo.config;

import com.example.demo.handler.AuthenticationSuccessHandler;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        //http.addFilterBefore(filter, CsrfFilter.class);
        http.csrf().disable();
        http
                .authorizeRequests()
                //特殊路徑如Css js，將存取存限都開
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .anyRequest().authenticated()
                .and().authorizeRequests()
                .antMatchers("/login").anonymous()
                .and()
                .formLogin()
                .loginPage("/login") .permitAll()
                //login成功時導向的page
                .defaultSuccessUrl("/com/helloJsp")
                //Spring Security 預設是找username，這邊是設定找自己頁面上的名稱
                .usernameParameter("username1")
                //Spring Security 預設是找password，這邊是設定找自己頁面上的名稱
                .passwordParameter("password1")
                //login成功時可利用Handler來在request及session來做一些基本資料的建立
                .successHandler(authSuccessHandler())
                .and()
                .logout()
                .permitAll()
                .invalidateHttpSession(true)
                //登出時導向的controller
                .logoutUrl("/j_spring_security_logout")
                //成功後導向的頁面
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .and()
                //這段開始是設定 RestFulAPI 走token
                .exceptionHandling()
                .and()
                //這段開始是設定 RestFulAPI 走token END
                .headers()
                .frameOptions().sameOrigin()
        ;//同網站下的frame網頁才允許載入;

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
    @Bean
    public AuthenticationSuccessHandler authSuccessHandler(){
        AuthenticationSuccessHandler authSuccessHandler = new AuthenticationSuccessHandler();
        /*
         * 設定true下,登入會導向DefaultTargetUrl,false時,會導向登入前所點的功能
         */
        authSuccessHandler.setAlwaysUseDefaultTargetUrl(true);
        authSuccessHandler.setDefaultTargetUrl("/com/helloJsp");
        authSuccessHandler.setUseReferer(true);
        return authSuccessHandler;
    }
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}