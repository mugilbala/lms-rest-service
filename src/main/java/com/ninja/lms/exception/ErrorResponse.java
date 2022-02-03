package com.ninja.lms.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder(value = {"code", "message", "details"})
public class ErrorResponse {

    //General error message about nature of error
    private String code;
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    public ErrorResponse(String code, String message, List<String> details) {
        super();
        this.code = code;
        this.message = message;
        this.details = details;
    }

    //Getter and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
