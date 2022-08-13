package com.example.ninja.model;

import com.example.ninja.CodeforcesService.Contest;

import java.util.List;

public class UserResponse {
    String status;
    private List<User> result=null;

    public UserResponse(String status, List<User> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }
}
