package com.repair.car.converters;

import com.repair.car.domain.User;
import com.repair.car.model.UserRegisterForm;


public class UserConverter {

    public static User buildUserObject(UserRegisterForm userRegisterForm) {
        User user = new User();
        user.setAfm(userRegisterForm.getAfm());
        user.setLastname(userRegisterForm.getLastname());
        user.setFirstname(userRegisterForm.getFirstname());
        user.setAddress(userRegisterForm.getAddress());
        user.setEmail(userRegisterForm.getEmail());
        user.setPassword(userRegisterForm.getPassword());
        user.setUserType(userRegisterForm.getUserType());

        return user;
    }

    public static UserRegisterForm buildUserForm(User user){


        UserRegisterForm userRegisterForm=new UserRegisterForm();

        userRegisterForm.setUserId(user.getUserId());
        userRegisterForm.setAfm(user.getAfm());
        userRegisterForm.setLastname(user.getLastname());
        userRegisterForm.setFirstname(user.getFirstname());
        userRegisterForm.setAddress(user.getAddress());
        userRegisterForm.setEmail(user.getEmail());
        userRegisterForm.setPassword(user.getPassword());
        userRegisterForm.setUserType(user.getUserType());

        return userRegisterForm;
    }


}
