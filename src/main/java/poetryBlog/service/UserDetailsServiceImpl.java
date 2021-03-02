package poetryBlog.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import poetryBlog.model.User;
import poetryBlog.repository.UserRepository;
import poetryBlog.security.UserRole;

import java.util.Collection;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("user not found"));

        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , user.getEnabled() , true , true , true , UserRole.USER.getAuthorities());
    }

}
