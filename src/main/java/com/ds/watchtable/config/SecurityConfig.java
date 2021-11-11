package com.ds.watchtable.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/join/join").permitAll();
        http.formLogin();
        http.csrf().disable();
        http.oauth2Login();
        http.headers().frameOptions().disable();
    }
}

//package com.ds.watchtable.config;
//
//        import com.ds.watchtable.security.filter.ApiCheckFilter;
//        import com.ds.watchtable.security.filter.ApiLoginFilter;
//        import com.ds.watchtable.security.handler.ApiLoginFailHandler;
//        import com.ds.watchtable.security.util.JWTUtil;
//        import lombok.extern.log4j.Log4j2;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//        import org.springframework.security.crypto.password.PasswordEncoder;
//        import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@Log4j2
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private ClubUserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/member/login").loginProcessingUrl("/login")
////                .successHandler(successHandler())
//                .failureUrl("/member/login?error");
//        http.csrf().disable();
//        http.logout();
////        http.oauth2Login().successHandler(successHandler());
//        http.rememberMe().tokenValiditySeconds(60 * 60 * 24 * 7).userDetailsService(userDetailsService);
//        http.addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(apiLoginFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.headers().frameOptions().sameOrigin();
//    }
//
//    @Bean
//    public ApiCheckFilter apiCheckFilter() {
//        return new ApiCheckFilter("/notes/**/*", jwtUtil());
//    }
//
//    @Bean
//    public ApiLoginFilter apiLoginFilter() throws Exception {
//        ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/api/login",jwtUtil());
//        apiLoginFilter.setAuthenticationManager(authenticationManager());
//        apiLoginFilter.setAuthenticationFailureHandler(new ApiLoginFailHandler());
//        return apiLoginFilter;
//    }
//
//    @Bean
//    public JWTUtil jwtUtil() {
//        return new JWTUtil();
//    }
//
//}
