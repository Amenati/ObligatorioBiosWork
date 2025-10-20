package uy.edu.bios.ejemplos.bioswork.configuracion;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/**").permitAll()
        // .requestMatchers("/fragmentos/**").permitAll()
        .requestMatchers("/ingresar/**").permitAll()
        .requestMatchers("/clientes/eliminar").hasAnyAuthority("consultor")
        .requestMatchers("/ofertas/**").access(new WebExpressionAuthorizationManager("isAnonymous() or hasAuthority('postulante')"))
        .anyRequest().authenticated())
        .formLogin(login -> login.permitAll());

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
        .requestMatchers("/css/**","/imagenes/**","/iconos/**");
    }

    // @Bean
    // public UserDetailsService authenticationManager(){
    //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    //     manager.createUser(
    //         org.springframework.security.core.userdetails.User.withUsername("con")
    //         .password("con123")
    //         .authorities("CONSULTOR").build()
    //         );

    //         return manager;
    // }

}

