package com.example.ninja.CodeforcesService;



import com.example.ninja.model.ProblemResponse;
import com.example.ninja.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("contest.list")   //from the url
    Call<ContestResult> getContestResult ();
    @GET("problemset.problems")
    Call<ProblemResponse> getProblemResponse();
}
