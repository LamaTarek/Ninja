package com.example.ninja.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ninja.Adapter.ProblemAdapter;
import com.example.ninja.CodeforcesService.ApiClient;
import com.example.ninja.CodeforcesService.ApiInterface;
import com.example.ninja.R;
import com.example.ninja.model.Problem;
import com.example.ninja.model.ProblemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProblemsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProblemAdapter problemAdapter;
    ApiInterface apiInterface;

    public ProblemsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_youtube, container, false);

        return view;
    }

    private void loadData() {
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getProblemResponse().enqueue(new Callback<ProblemResponse>() {
            @Override
            public void onResponse(Call<ProblemResponse> call, Response<ProblemResponse> response) {
                if(response.isSuccessful()){
                    List<Problem> problemList=response.body().getResult().getProblemList();
                    for (int i = 0; i < problemList.size(); i++) {
                        problemAdapter=new ProblemAdapter(getContext(),problemList);
                        recyclerView.setAdapter(problemAdapter);
                        problemAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProblemResponse> call, Throwable t) {
                Log.e("Error: ",t.toString());
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}