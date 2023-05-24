package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("+989354821771");
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMailApp();
            }
        });
        TextView bio = findViewById(R.id.textView2);
        bio.setMovementMethod(new ScrollingMovementMethod());
        InputStream inputStream = this.getResources().openRawResource(R.raw.bio);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        if (inputStream!=null){
            try{
                while ((str = bufferedReader.readLine())!=null){
                    stringBuffer.append(str);
                }
                bio.setText(stringBuffer);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        View rootView = findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(rootView, "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWelcome to my profile<3", 10000);
        snackbar.show();


        ToggleButton toggleButton = findViewById(R.id.toggleButton);

// Set an initial state for the toggle button
        toggleButton.setChecked(false);  // Set to light mode initially

// Set an OnCheckedChangeListener to handle toggle button clicks
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Dark mode is enabled
                    setDarkMode();
                } else {
                    // Light mode is enabled
                    setLightMode();
                }
            }
        });
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    private void openMailApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        startActivity(intent);
    }

    private void setDarkMode() {
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        // Change the background color of the main layout to a dark color
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.setBackgroundColor(getResources().getColor(R.color.dark_mode_background));

        // Change the text color of TextViews
        TextView textViewTest = findViewById(R.id.textViewTest);
        textViewTest.setTextColor(getResources().getColor(R.color.dark_mode_text));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setTextColor(getResources().getColor(R.color.dark_mode_text));
        TextView titleBio = findViewById(R.id.titleBio);
        titleBio.setTextColor(getResources().getColor(R.color.dark_mode_text));

        // Change the text color of buttons
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        button.setTextColor(getResources().getColor(R.color.dark_mode_text));
        button2.setTextColor(getResources().getColor(R.color.dark_mode_text));

        // Change the text color and background color of the ToggleButton
        toggleButton.setTextColor(getResources().getColor(R.color.dark_mode_text));
        toggleButton.setBackgroundColor(getResources().getColor(R.color.dark_mode_toggle_background));

    }

    private void setLightMode() {
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        // Reset the background color of the main layout to the default color
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));

        // Reset the text color of TextViews
        TextView textViewTest = findViewById(R.id.textViewTest);
        textViewTest.setTextColor(getResources().getColor(android.R.color.black));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setTextColor(getResources().getColor(android.R.color.black));
        TextView titleBio = findViewById(R.id.titleBio);
        titleBio.setTextColor(getResources().getColor(android.R.color.black));

        // Reset the text color of buttons
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        button.setTextColor(getResources().getColor(android.R.color.black));
        button2.setTextColor(getResources().getColor(android.R.color.black));

        // Reset the text color and background color of the ToggleButton
        toggleButton.setTextColor(getResources().getColor(android.R.color.black));
        toggleButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        // Additional changes specific to light mode
        // ...

        // Save the current theme preference (e.g., in SharedPreferences)
        // ...
    }
}