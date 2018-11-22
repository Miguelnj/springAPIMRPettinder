package es.ulpgc.gs1.gs1prototype.security;

import es.ulpgc.gs1.gs1prototype.controller.MessageController;
import es.ulpgc.gs1.gs1prototype.controller.SubforumController;
import es.ulpgc.gs1.gs1prototype.controller.ThreadController;
import es.ulpgc.gs1.gs1prototype.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(11));
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception     {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(SubforumController.subforumPath).authenticated()
                .antMatchers(ThreadController.threadPath).authenticated()
                .antMatchers(MessageController.messagePath).authenticated()
                .antMatchers(UserController.userPath).authenticated()
                .antMatchers("/h2_console/**").permitAll()
                .and().formLogin().loginPage(UserController.loginPath).permitAll()
                .defaultSuccessUrl("/subforums", true)
                .and().logout().permitAll()
                .and().httpBasic();

        http.headers().frameOptions().disable();
        http.cors();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
