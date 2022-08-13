package com.example.ninja.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninja.Adapter.ContestAdapter;
import com.example.ninja.CodeforcesService.ApiClient;
import com.example.ninja.CodeforcesService.ApiInterface;
import com.example.ninja.CodeforcesService.Contest;
import com.example.ninja.CodeforcesService.ContestResult;
import com.example.ninja.MainActivity;
import com.example.ninja.R;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContestFragment extends Fragment {
    private RecyclerView recyclerView;
    private ContestAdapter contestAdapter;
    ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contest, container, false);
        //recyclerview stuff
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //load data from the web service
        loadData();
        return view;
    }

    private void loadData() {
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getContestResult().enqueue(new Callback<ContestResult>() {
            @Override
            public void onResponse(Call<ContestResult> call, Response<ContestResult> response) {
                if(response.isSuccessful()){
                    List<Contest> contestList=response.body().getResult();
                    for (int i = 0; i < contestList.size(); i++) {
                        contestAdapter=new ContestAdapter(getContext(),contestList);
                        recyclerView.setAdapter(contestAdapter);
                        contestAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ContestResult> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}