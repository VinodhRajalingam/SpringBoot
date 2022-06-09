package in.tn.srv.springboot.securitycontainer;

import in.tn.srv.springboot.entitycontainer.User;
import in.tn.srv.springboot.repocontainer.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity()
public class SecurityConfigurer implements AuthenticationProvider {

    @Autowired
    UserRepo userRepo;

   @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String userCredential = authentication.getCredentials().toString();
        User userFromDB = userRepo.findByfirstName(userName);
        if (userFromDB != null) {
            if  (userCredential.equals(userFromDB.getPassword()))
                    return new UsernamePasswordAuthenticationToken(
                        userFromDB.getFirstName(),
                        userFromDB.getPassword(),
                        grantedAuthorities(userFromDB));
            else
                throw new BadCredentialsException("Bad Credentials");
        }
        else
            throw new UsernameNotFoundException("User Name Not Found");
    }

    private Collection<? extends GrantedAuthority> grantedAuthorities(User userByUserName) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userByUserName.getRole()));
        return authorities;
    }

    @Bean
    public SecurityFilterChain filterChainAuth(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/users*").hasRole("ADMIN")
                .antMatchers("/user/*").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();

        return http.build();

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
