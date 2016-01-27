package edu.ucc.gestionestudiantes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetails;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import edu.ucc.gestionestudiantes.servicios.ServicioEstudiante;

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
    	http.authorizeRequests().antMatchers("/estudiantes").authenticated();
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/editar").authenticated();
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/actualizar").authenticated();
        http.authorizeRequests().antMatchers("estudiantes/{idEstudiante}/eliminar").authenticated();
        http.authorizeRequests().antMatchers("/HomeAdministrador").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/HomeUsuario").authenticated();

        
//        http.formLogin()
//        .defaultSuccessUrl("/estudiantes")
//        .loginPage("/HomeAdmin")
//        .permitAll()
//        .and()
//        .logout()
//        .logoutSuccessUrl("/logout")
//        .permitAll();
        
//        http.csrf().disable();
        
          
        http.formLogin()
                .defaultSuccessUrl("/HomeAdministrador")
//                .defaultSuccessUrl("/HomeAdministrador")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
//        NombreRol=${Admin}
//        NombreRol=${rol_usuario.nombre_rol}
//        "@{/estudiantes/{idEstudiante}/editar(idEstudiante=${estudiante.numeroIdentificacion})}"
        //http.csrf().disable();
//        http.authorizeRequests()
//                        .antMatchers("/**").authenticated()
//                        .antMatchers("/shutdown").permitAll()
//                        .and().formLogin().passwordParameter("password").usernameParameter("username")
//                        .and().formLogin().loginPage("/login").permitAll()
//                        .and().formLogin().loginProcessingUrl("/HomeAdmin")
//                        .and().formLogin().failureUrl("/HomeAdmin")
//                        .and().formLogin().defaultSuccessUrl("/",false);
        
//        http.csrf().disable();
//        http.authorizeRequests()
//                        .antMatchers("/**").authenticated()
//                        .antMatchers("/shutdown").permitAll()
//                        .and().formLogin().passwordParameter("password").usernameParameter("username")
//                        .and().formLogin().loginPage("/authentication.html").permitAll()
//                        .and().formLogin().loginProcessingUrl("/login")
//                        .and().formLogin().failureUrl("/authentication.html")
//                        .and().formLogin().defaultSuccessUrl("/",false);
        
//      http
//      .csrf().disable()
//      .authorizeRequests()
//          .antMatchers("/shutdown").permitAll()
//          .anyRequest().authenticated()
//          .and()
//      .formLogin()
//          .loginPage("/HomeAdmin")
//          .loginProcessingUrl("/login")
//          .failureUrl("/HomeAdmin")
//          .permitAll();
      
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