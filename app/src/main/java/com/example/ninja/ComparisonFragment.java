package com.example.ninja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ninja.CodeforcesService.CodeforcesAPI;
import com.example.ninja.model.User;

public class ComparisonFragment extends Fragment {
    TextView userhandle, rating, maxrating, rank, maxrank;
    TextView userhandle2, rating2, maxrating2, rank2, maxrank2;

String handle1,handle2;
    public ComparisonFragment() {
        // Required empty public constructor
    }
    public ComparisonFragment(String handle2,String handle1) {
        this.handle1=handle1;
        this.handle2=handle2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comparison, container, false);
        userhandle = view.findViewById(R.id.userHandle);
        rating = view.findViewById(R.id.rating);
        maxrating = view.findViewById(R.id.maxrating);
        rank = view.findViewById(R.id.rank);
        maxrank = view.findViewById(R.id.maxrank);
        userhandle2 = view.findViewById(R.id.userHandle2);
        rating2 = view.findViewById(R.id.rating2);
        maxrating2 = view.findViewById(R.id.maxrating2);
        rank2 = view.findViewById(R.id.rank2);
        maxrank2 = view.findViewById(R.id.maxrank2);

        final CodeforcesAPI codeforcesService=new CodeforcesAPI(getActivity());
        codeforcesService.getUserProfile(handle1, new CodeforcesAPI.ReportResponseListener() {
            @Override
            public void onError(String message) {
                Log.d("Error", message);
            }

            @Override
            public void onResponse(User userProfile) {
                userhandle.setText(userProfile.getHandle());
                rating.setText(Integer.toString(userProfile.getRating()));
                maxrating.setText(Integer.toString(userProfile.getMaxRating()));
                maxrank.setText(userProfile.getMaxRank());


            }
        });
        codeforcesService.getUserProfile(handle2, new CodeforcesAPI.ReportResponseListener() {
            @Override
            public void onError(String message) {
                Log.d("Error", message);
            }

            @Override
            public void onResponse(User userProfile) {
                userhandle2.setText(userProfile.getHandle());
                rating2.setText(Integer.toString(userProfile.getRating()));
                maxrating2.setText(Integer.toString(userProfile.getMaxRating()));
                maxrank2.setText(userProfile.getMaxRank());

            }
        });

        return view;
    }
}