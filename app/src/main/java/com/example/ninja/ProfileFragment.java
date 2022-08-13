package com.example.ninja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninja.CodeforcesService.CodeforcesAPI;
import com.example.ninja.model.User;
import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {
    TextView userhandle, rating, maxrating, rank, maxrank;
    String handle;
    final CodeforcesAPI volleyService = new CodeforcesAPI(getActivity());

    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(String handle) {
        this.handle = handle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //  Toast.makeText(getActivity(),"hello "+handle,Toast.LENGTH_SHORT).show();
        userhandle = view.findViewById(R.id.userHandle);
        rating = view.findViewById(R.id.rating);
        maxrating = view.findViewById(R.id.maxrating);
        rank = view.findViewById(R.id.rank);
        maxrank = view.findViewById(R.id.maxrank);
        final CodeforcesAPI codeforcesService=new CodeforcesAPI(getActivity());
        codeforcesService.getUserProfile(handle, new CodeforcesAPI.ReportResponseListener() {
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
        return view;
    }


}