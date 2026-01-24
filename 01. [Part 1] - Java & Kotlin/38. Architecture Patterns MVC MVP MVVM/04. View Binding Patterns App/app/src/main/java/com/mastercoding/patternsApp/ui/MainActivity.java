 package com.mastercoding.patternsApp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mastercoding.patternsApp.R;
import com.mastercoding.patternsApp.databinding.ActivityMainBinding;


 public class MainActivity extends AppCompatActivity{


    // 6- Connecting MainActivity with ViewModel and Listening to LIVE Data
     AppViewModel appViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // instead of using deprecated methods
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // 7- View binding with Textview will do the job of observing
        binding.setViewModel(appViewModel);
        binding.setLifecycleOwner(this);
        

    }

     //     MVC Pattern
    // View: TextView & Button (Main Activity)
    // Model: MyModel class
    // Controller: MainActivity


     //      MVP Pattern
     // View : Activity with Textview & Button
     // Model: My Model
     // Presenter: AppPresenter


     // MVVM
     // 1- Implementing the dependency of ViewModel
     // 2- Creating ViewModel Class

     //Amazing Guys !! We have implemented MVVM correctly
}