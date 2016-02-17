package edu.ucc.gestionestudiantes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static PasswordEncoder encoder;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	
//    	http.authorizeRequests().antMatchers("/HomeAdministrador").authenticated();
//        http.authorizeRequests().antMatchers("/HomeUsuario").authenticated();
    	http.authorizeRequests().antMatchers("/estudiantes").fullyAuthenticated();
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/editar").fullyAuthenticated();
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/actualizar").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/eliminar").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/programas").hasAuthority("Admin");
//        http.authorizeRequests().antMatchers("/programas/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/programa/**").hasAuthority("Admin");
//        http.authorizeRequests().antMatchers("eventos/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("evento/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/HomeAdministrador").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/HomeUsuario").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/Home").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/programasInscripcion").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/eventosInscripcion").fullyAuthenticated();

        
        http.formLogin()
                .defaultSuccessUrl("/Home")
                .failureUrl("/login?error")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        if(encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }

        return encoder;
    }
}