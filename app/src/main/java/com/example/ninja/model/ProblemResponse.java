package com.example.ninja.model;

import com.example.ninja.CodeforcesService.Contest;

import java.util.List;

public class ProblemResponse {
    String status;
    ProblemResult result;
    //constructor

    public ProblemResponse(String status, ProblemResult result) {
        this.status = status;
        this.result = result;
    }


    //getter and setter


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProblemResult getResult() {
        return result;
    }

    public void setResult(ProblemResult result) {
        this.result = result;
    }
}
