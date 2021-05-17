package com.onthetrip.example.web.controller.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ApiResponse<T> {
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    private String resultCode;
    private T body;

    public static <T> ApiResponse<T> success(T body) {
        return new ApiResponse(SUCCESS, body);
    }

    public static <T> ApiResponse<T> fail(T body) {
        return new ApiResponse(FAIL, body);
    }

    public static <T> ApiResponse<T> customFail(String failCode, T body) {
        return new ApiResponse(failCode, body);
    }
}
