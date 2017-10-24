package com.repair.car.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserSearchForm {

//    private static final String EMAIL_AFM_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";
//
//    private static final String NUMBERS_PATTERN = "^[0-9]*$";
//
//
//    private static final int AFM_SIZE = 9;
//
//
//    @Pattern(regexp = NUMBERS_PATTERN, message = "{register.afm.invalid}")
//    @Size(min = AFM_SIZE, max = AFM_SIZE, message = "{register.afm.size}")
//    private String afm;
//
//    @NotEmpty(message = "{register.email.empty}")
//    @Pattern(regexp = EMAIL_PATTERN, message = "{register.email.invalid}")
//    private String email;

    private String userSearchText;

    private String userSearchType;


    public String getUserSearchText() { return userSearchText; }

    public void setUserSearchText(String userSearchText) { this.userSearchText = userSearchText; }

    public String getUserSearchType() { return userSearchType; }

    public void setUserSearchType(String userSearchType) { this.userSearchType = userSearchType; }
}
