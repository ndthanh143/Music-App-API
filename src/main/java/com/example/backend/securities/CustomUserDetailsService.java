package com.example.backend.securities;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JwtUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUser(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Tài khoản có email %s không tồn tại", email)));
        return getUserDetails(user);
    }

    private JwtUserDetails getUserDetails(User taiKhoan) {
        return new JwtUserDetails(
                taiKhoan.getName(),
                taiKhoan.getEmail(),
                taiKhoan.getPassword(),
                taiKhoan.getAuthorities(),
                taiKhoan.isTrangThai()
        );
    }
}
