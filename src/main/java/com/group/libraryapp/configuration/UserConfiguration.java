package com.group.libraryapp.configuration;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.transform.Templates;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository(JdbcTemplate jdbcTemplate) {
        return new UserRepository(jdbcTemplate);
    }

}
