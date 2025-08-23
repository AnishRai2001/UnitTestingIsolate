package com.example.demo2.mvc;


import com.example.demo2.controller.UserController;
import com.example.demo2.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService mockService;

    @InjectMocks
    private UserController controller;

    @Test
    void testGetUserName_Found() {
        // Mock the service
        //  UserService mockService = mock(UserService.class);
        when(mockService.getUserName(1)).thenReturn("Alice");

        // Inject into controller
        UserController controller = new UserController(mockService);

        // Call method & assert
        assertEquals("Alice", controller.getUserName(1));

        // Verify interaction
        verify(mockService, times(1)).getUserName(1);
    }
    @Test
    void testGetUserName_NotFound() {
        UserService mockService = mock(UserService.class);
        when(mockService.getUserName(2)).thenReturn("Unknown User");

        UserController controller = new UserController(mockService);

        assertEquals("Unknown User", controller.getUserName(2));

        verify(mockService, times(1)).getUserName(2);
    }
}