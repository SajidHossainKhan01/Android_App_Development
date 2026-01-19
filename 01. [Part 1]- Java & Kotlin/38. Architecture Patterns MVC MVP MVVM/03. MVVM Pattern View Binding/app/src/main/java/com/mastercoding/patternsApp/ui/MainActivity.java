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
import com.mastercoding.patternsApp.util.MyModel;

 public class MainActivity extends AppCompatActivity{

    Button btn;
    TextView textView;

    // 6- Connecting MainActivity with ViewModel and Listening to LIVE Data
     AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    appViewModel.getAppName();
            }
        });

        // instead of using deprecated methods
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // 7- Listening & observing the changes to Live Data
        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                 // Any Change in the live data do this:
                textView.setText(s);

            }
        });


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