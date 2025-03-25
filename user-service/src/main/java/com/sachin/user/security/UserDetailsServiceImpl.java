package com.sachin.user.security;

import com.sachin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;  // ✅ FIXED
import org.springframework.security.core.userdetails.UserDetailsService;  // ✅ FIXED
import org.springframework.security.core.userdetails.UsernameNotFoundException;  // ✅ FIXED
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
    public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));
    }
}
