package in.tn.srv.springboot.securityconfigscontainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        List<UserDetails> userDetailsList = new ArrayList<UserDetails>();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("vinod")
                .password("pass")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("raja")
                .password("pass")
                .roles("USER")
                .build();
        userDetailsList.add(user1);
        userDetailsList.add(user2);
        return new InMemoryUserDetailsManager(userDetailsList);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/user").hasRole("USER")
                        .antMatchers("/admin").hasRole("ADMIN")
                        .antMatchers("/").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated()
                ).httpBasic(withDefaults());

        return http.build();
    }
}
