package com.clarit.hs.service.items.model;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class LoginResponse {
    private String access_token;
  @JsonIgnore
    private String refresh_token;
    @JsonIgnore
    private String expiry_in;
    @JsonIgnore
    private String refresh_expiry_in;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
   }

    public void setRefresh_token(String refresh_token) {
       this.refresh_token = refresh_token;
    }

    public String getExpiry_in() {
        return expiry_in;
    }

    public void setExpiry_in(String expiry_in) {
        this.expiry_in = expiry_in;}

    public String getRefresh_expiry_in() {
        return refresh_expiry_in;
    }

   public void setRefresh_expiry_in(String refresh_expiry_in) {
        this.refresh_expiry_in = refresh_expiry_in;
    }
}
