package com.example.ninja.CodeforcesService;

import java.util.List;

public class ContestResult {
    String status;
    private List<Contest>result=null;

    public ContestResult(String status, List<Contest> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contest> getResult() {
        return result;
    }

    public void setResult(List<Contest> result) {
        this.result = result;
    }
}
