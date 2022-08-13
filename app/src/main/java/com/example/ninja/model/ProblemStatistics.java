package com.example.ninja.model;

public class ProblemStatistics {
    int contestId;
    String index;
    int solvedCount;
    //constructor

    public ProblemStatistics(int contestId, String index, int solvedCount) {
        this.contestId = contestId;
        this.index = index;
        this.solvedCount = solvedCount;
    }
    //setter and getter

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public void setSolvedCount(int solvedCount) {
        this.solvedCount = solvedCount;
    }
}
