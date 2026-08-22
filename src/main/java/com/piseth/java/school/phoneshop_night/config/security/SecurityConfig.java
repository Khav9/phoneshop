package com.piseth.java.school.phoneshop_night.config.security;

import com.piseth.java.school.phoneshop_night.config.jwt.JwtLoginFilter;
import com.piseth.java.school.phoneshop_night.config.jwt.TokenVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

import static com.piseth.java.school.phoneshop_night.config.security.PermissionEnum.*;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilterAfter(new TokenVerifyFilter(), JwtLoginFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/", "index.html", "css/**", "js/**").permitAll()
                //can use in this but it might be growth to long if we have many api
                //.antMatchers(HttpMethod.POST, "/brands").hasAuthority(BRAND_WRITE.getDescription())
                //.antMatchers(HttpMethod.GET, "/brands").hasAuthority(BRAND_READ.getDescription())
                .anyRequest()
                .authenticated();
//                .and()
//                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //store data in memory
        //User user1 = new User("dara", "dara123", null); error when pass null
        //User user1 = new User("dara", passwordEncoder.encode("dara123"), Collections.emptyList());
        UserDetails user1 = User.builder()
                .username("data")
                .password(passwordEncoder.encode("data123"))
                //.roles("SALE") //ROLE_SALE
                .authorities(RoleEnum.SALE.getAuthorities())
                .build();

        UserDetails user2 = User.builder()
                .username("tida")
                .password(passwordEncoder.encode("tida123"))
                //.roles("ADMIN") // ROLE_ADMIN
                .authorities(RoleEnum.ADMIN.getAuthorities())
                .build();

        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user1, user2);
        return userDetailsService;
    }
}
