package com.example.ninja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ninja.Fragment.ContestFragment;
import com.example.ninja.Fragment.ProblemsFragment;
import com.example.ninja.Fragment.UserFragment;
import com.example.ninja.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ContestFragment());
        getSupportActionBar().setTitle("Contests");
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_contest:
                    replaceFragment(new ContestFragment());
                    getSupportActionBar().setTitle("Contests");
                    break;
                case R.id.nav_user:
                    replaceFragment(new UserFragment());
                    getSupportActionBar().setTitle("Find User");
                    break;
                case R.id.nav_compare:
                    replaceFragment(new CompareFragment());
                    getSupportActionBar().setTitle("Compare");
                    break;
                case R.id.nav_problems:
                    replaceFragment(new ProblemsFragment());
                    getSupportActionBar().setTitle("Tutorial");
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

}