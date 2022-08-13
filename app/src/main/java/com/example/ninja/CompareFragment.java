package com.example.ninja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class CompareFragment extends Fragment {

    EditText handleSearch2;
    Button btnSearchHandle;
    EditText handleSearch;


    public CompareFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_compare, container, false);
        handleSearch=view.findViewById(R.id.handleSearch);
        btnSearchHandle=view.findViewById(R.id.btnSearchHandle);
        handleSearch2=view.findViewById(R.id.handleSearch2);
        btnSearchHandle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String handle1=handleSearch.getText().toString();
               String handle2=handleSearch2.getText().toString();
               if(handleSearch.getText().toString().compareToIgnoreCase("") == 0 || handleSearch2.getText().toString().compareToIgnoreCase("") == 0){
                   Toast.makeText(getActivity(),"Handle field cannot be empty",Toast.LENGTH_SHORT).show();
               }else {
                   handleSearch.setVisibility(View.GONE);
                   handleSearch2.setVisibility(View.GONE);
                   btnSearchHandle.setVisibility(View.GONE);
                   FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                   fragmentTransaction.replace(R.id.compareContainer, new ComparisonFragment(handle1,handle2));
                   fragmentTransaction.commit();
               }
           }
       });
        return view;
    }
}