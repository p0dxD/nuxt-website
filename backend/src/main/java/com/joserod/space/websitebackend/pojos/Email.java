package com.joserod.space.websitebackend.pojos;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Email {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("message")
    private String message;

    public String getFullName(){
        return this.fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }
}