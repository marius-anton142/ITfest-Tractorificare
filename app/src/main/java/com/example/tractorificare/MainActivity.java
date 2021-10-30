package com.example.tractorificare;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Intent loginActivity, profileActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity = new Intent(this, LoginActivity.class);
        profileActivity = new Intent(this, ProfileActivity.class);
        if (FirebaseAuth.getInstance().getCurrentUser() != null)
            startActivity(profileActivity);
        else
            startActivity(loginActivity);


    }
}
