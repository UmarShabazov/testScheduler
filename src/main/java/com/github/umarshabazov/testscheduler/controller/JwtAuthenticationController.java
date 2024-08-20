package com.github.umarshabazov.testscheduler.controller;
import com.github.umarshabazov.testscheduler.dto.UserDto;
import com.github.umarshabazov.testscheduler.entities.UserEntity;
import com.github.umarshabazov.testscheduler.repositories.UserRepository;
import com.github.umarshabazov.testscheduler.security.JwtRequest;
import com.github.umarshabazov.testscheduler.security.JwtResponse;
import com.github.umarshabazov.testscheduler.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

   @Autowired
   private UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        // Сохранение пользователя в базе данных

        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
