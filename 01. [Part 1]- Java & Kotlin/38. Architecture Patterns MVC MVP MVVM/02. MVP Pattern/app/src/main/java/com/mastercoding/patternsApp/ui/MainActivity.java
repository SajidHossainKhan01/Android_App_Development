 package com.mastercoding.patternsApp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mastercoding.patternsApp.R;
import com.mastercoding.patternsApp.util.MyModel;

 public class MainActivity extends AppCompatActivity implements AppView{

    // 1- let's organize the packages
    // 2- implementing MVP Pattern

    Button btn;
    TextView textView;

    // Linking Activity with Presenter
     AppPresenter appPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // Instantiating The Presenter
        appPresenter = new AppPresenter(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling the Presenter to get data from DB
                // No linkage between Activity and Model
                // Our MainActivity is Handling UI ONLY!!
                // All Logic occurs at the presenter
                appPresenter.getAppName();
            }
        });

    }


     @Override
     public void onGetAppName(String string) {
        textView.setText(string);

     }


     //     MVC Pattern
    // View: TextView & Button (Main Activity)
    // Model: MyModel class
    // Controller: MainActivity


     //      MVP Pattern
     // View : Activity with Textview & Button
     // Model: My Model
     // Presenter: AppPresenter


}