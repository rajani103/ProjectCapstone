//package com.stackroute.controller;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.model.User;
//import com.stackroute.service.AuthenticationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private AuthenticationService authenticationService;
//    private User user;
//    private List<User> userList;
//
//    @InjectMocks
//    private UserController userController;
//
//    @BeforeEach
//    public void setUp(){
//        user =  new User("mehboob@gmail.com", "Mmhm@123");
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//
//    @Test
//    public void givenUserToSaveShouldReturnSavedUser() throws Exception {
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(post("/api/v1/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(user)))
//                .andExpect(status().isCreated());
//        verify(userService,times(1)).saveUser(any());
//    }
//
//
//    public static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}