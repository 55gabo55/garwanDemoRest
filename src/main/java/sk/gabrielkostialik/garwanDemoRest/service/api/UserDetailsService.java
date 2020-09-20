package sk.gabrielkostialik.garwanDemoRest.service.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username);
}
