package com.rhonn.board_back.common;

public interface ResponseMessage {

    // HTTP Status 200
    String SUCCESS = "Sucess";

    // HTTP Status 400
    String VALIDATION_FAILED = "Validation Failed";
    String DUPLICATED_EMAIL = "Duplicate Email";
    String DUPLICATED_NICKNAME = "Duplicate nickname";
    String DUPLICATED_TEL_NUMBER = "Duplicate Telnumber";
    String NOT_EXISTED_USER = "Not existed User";
    String NOT_EXISTED_BOARD = "Not existed Board";

    // HTTP Status 401
    String SIGN_IN_FAIL = "Login information mismatch";
    String AUTHORIZATION_FAIL = "Authorization Failed";

    // HTTP Status 403
    String NO_PERMISSION = "No Permission";

    // HTTP Status 500
    String DATABASE_ERROR = "Database Error";
}
