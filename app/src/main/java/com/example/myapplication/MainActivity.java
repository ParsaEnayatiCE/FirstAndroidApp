package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        toggleButton.setChecked(false);  // Set to light mode initially
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
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.setBackgroundColor(getResources().getColor(R.color.dark_mode_background));

        TextView textViewTest = findViewById(R.id.textViewTest);
        textViewTest.setTextColor(getResources().getColor(R.color.dark_mode_text));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setTextColor(getResources().getColor(R.color.dark_mode_text));
        TextView titleBio = findViewById(R.id.titleBio);
        titleBio.setTextColor(getResources().getColor(R.color.dark_mode_text));

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        button.setTextColor(getResources().getColor(R.color.dark_mode_text));
        button2.setTextColor(getResources().getColor(R.color.dark_mode_text));

        toggleButton.setTextColor(getResources().getColor(R.color.dark_mode_text));
        toggleButton.setBackgroundColor(getResources().getColor(R.color.dark_mode_toggle_background));
    }

    private void setLightMode() {
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));

        TextView textViewTest = findViewById(R.id.textViewTest);
        textViewTest.setTextColor(getResources().getColor(android.R.color.black));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setTextColor(getResources().getColor(android.R.color.black));
        TextView titleBio = findViewById(R.id.titleBio);
        titleBio.setTextColor(getResources().getColor(android.R.color.black));

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        button.setTextColor(getResources().getColor(android.R.color.black));
        button2.setTextColor(getResources().getColor(android.R.color.black));

        toggleButton.setTextColor(getResources().getColor(android.R.color.black));
        toggleButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
}