package com.github.umarshabazov.testscheduler.controller;

import com.github.umarshabazov.testscheduler.TestSchedulerApplication;
import com.github.umarshabazov.testscheduler.security.JwtRequest;
import com.github.umarshabazov.testscheduler.entities.UserEntity;
import com.github.umarshabazov.testscheduler.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestSchedulerApplication.class)
class JwtAuthenticationControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        // Подготовка данных в базе перед каждым тестом
        userRepository.deleteAll();
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setEmail("email");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRole("author");
        userRepository.save(user);
    }

    @Test
    void testCreateAuthenticationToken() {
        // Создаем запрос для аутентификации
        JwtRequest request = new JwtRequest("testuser", "password");
        HttpEntity<JwtRequest> entity = new HttpEntity<>(request, new HttpHeaders());

        // Отправляем запрос на аутентификацию
        ResponseEntity<String> response = restTemplate.exchange("/authenticate", HttpMethod.POST, entity, String.class);

        // Проверяем, что запрос выполнен успешно и токен получен
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
