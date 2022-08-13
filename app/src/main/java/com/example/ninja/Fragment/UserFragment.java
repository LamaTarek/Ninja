package com.example.ninja.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninja.ProfileFragment;
import com.example.ninja.R;
import com.example.ninja.databinding.ActivityMainBinding;


public class UserFragment extends Fragment {
    EditText handleSearch;
    Button btnSearchHandle;
    ImageView ic_search;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user, container, false);
        handleSearch=view.findViewById(R.id.handleSearch);
        btnSearchHandle=view.findViewById(R.id.btnSearchHandle);
        ic_search=view.findViewById(R.id.ic_search);
        btnSearchHandle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String handle=handleSearch.getText().toString();
                if(handleSearch.getText().toString().compareToIgnoreCase("") == 0){
                    Toast.makeText(getActivity(),"Handle field cannot be empty",Toast.LENGTH_SHORT).show();
                }else {
                    handleSearch.setVisibility(View.GONE);
                    btnSearchHandle.setVisibility(View.GONE);
                    ic_search.setVisibility(View.GONE);
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.userContainer, new ProfileFragment(handle));
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }

}