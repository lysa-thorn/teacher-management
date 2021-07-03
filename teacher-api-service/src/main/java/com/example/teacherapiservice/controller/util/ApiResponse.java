package com.example.teacherapiservice.controller.util;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiResponse<T> {

    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pagination pagination;

    public ApiResponse() {
        this.code = "OK";
        this.message = "OK";
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(T data) {
        this.code = "OK";
        this.message = "OK";
        this.data = data;
    }

    public ApiResponse(T data, Pagination pagination) {
        this.code = "OK";
        this.message = "OK";
        this.data = data;
        this.pagination = pagination;
    }

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(String code, String message, T data, Pagination pagination){
        this.code = code;
        this.message = message;
        this.data = data;
        this.pagination = pagination;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
