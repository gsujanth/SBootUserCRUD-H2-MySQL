package com.training.springbootdemo.service;

import com.training.springbootdemo.model.User;
import com.training.springbootdemo.repository.UserRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit-test")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getDefaultUserTest() {
        User user = new User(1, "firstN", "lastN");
        when(userRepository.findByLastName("lastN")).thenReturn(user);

        User user2 = userService.getUser("lastN");
        verify(userRepository).findByLastName("lastN");
        assertThat(user).isEqualTo(user2);
    }
}
