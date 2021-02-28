package com.example.wechat.startup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wechat.MainActivity;
import com.example.wechat.R;
import com.example.wechat.auth.PhoneLoginActivity;

public class WelcomeScreenActivity extends AppCompatActivity {

    AppCompatButton btnAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        btnAgree = findViewById(R.id.buttonAgreeID);

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeScreenActivity.this, PhoneLoginActivity.class));

                finish();

            }
        });
    }
}