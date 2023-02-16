package com.SwitchEnergySystem.dto;

public class JwtRequest {
    private String token;
    public JwtRequest(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}