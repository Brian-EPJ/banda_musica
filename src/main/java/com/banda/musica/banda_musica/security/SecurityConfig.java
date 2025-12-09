package com.banda.musica.banda_musica.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas (sin login)
                        .requestMatchers("/", "/contacto", "/contacto/**",
                                "/css/**", "/img/**").permitAll()

                        // Rutas privadas (solo admin)
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Todo lo demás es público
                        .anyRequest().permitAll()
                )
                // Login solo cuando intentes entrar al admin
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("Kolossal2025!")) // cambia esta
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}

