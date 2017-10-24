package com.repair.car.services;

import com.repair.car.domain.User;
import com.repair.car.model.UserRegisterForm;
import org.springframework.security.core.AuthenticationException;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User login(String email, String password) throws AuthenticationException;

    void logout(String email) throws Exception;

    void register(User user) throws Exception;

    List<UserRegisterForm> userSearch(String userSearchText, String userSearchType) ;

     void deleteById(Long userId);

    User findUserByAfm(String afm) ;

    List<UserRegisterForm> findAllUsers();


}
