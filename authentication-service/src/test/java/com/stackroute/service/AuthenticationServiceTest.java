// package com.stackroute.service;
// import com.stackroute.exception.UserNotFoundException;
// import com.stackroute.model.*;
// import com.stackroute.repository.UserRepo;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import java.util.Optional;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;
// @ExtendWith(MockitoExtension.class)
// public class AuthenticationServiceTest {
//     @Mock
//     private UserRepo userRepository;

//     @InjectMocks
//     private AuthenticationServiceImpl userService;
//     private User user;
//     private Optional optional;

//     @BeforeEach
//     public void setUp(){
//         MockitoAnnotations.initMocks(this);
//         user = new User("mehboob@gmail.com", "Mmhm@123");
//         optional = Optional.of(user);
//     }

//     @AfterEach
//     public void tearDown(){
//         user = null;
//     }

//     @Test
//     public void givenUserToSaveShouldReturnSavedUser() {
//         when(userRepository.save(any())).thenReturn(user);
//         assertEquals(user,userService.saveUser(user));
//         verify(userRepository,times(1)).save(any());
//     }



//     @Test
//     public void givenEmailIdAndPasswordToGetUserThenReturnUser() throws UserNotFoundException, UserNotFoundException {
//         when(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);
//         User getUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
//         assertEquals(user, getUser);

//     }

// }
