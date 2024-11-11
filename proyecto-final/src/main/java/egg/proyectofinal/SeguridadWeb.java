/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author 54113
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SeguridadWeb {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        http.authorizeHttpRequests((requests) -> {
            try {
                requests
                        .requestMatchers("/css/*","/js/*","/img/*", "/**")
                        .permitAll()
                        .and().formLogin()
                        .loginPage("/homecontroller/login")
                        .loginProcessingUrl("/homecontroller/logincheck")
                        .usernameParameter("nombre")
                        .passwordParameter("contrasena")
                        .defaultSuccessUrl("/homecontroller/inicio")
                        .permitAll()
                        .and().logout()
                        .logoutUrl("/homecontroller/inicio")
                        .logoutSuccessUrl("/homecontroller/inicio")
                        .permitAll();
            } catch (Exception ex) {
                Logger.getLogger(SeguridadWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
        );
        return http.build();        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
} 
