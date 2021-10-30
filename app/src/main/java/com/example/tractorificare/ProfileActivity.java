package com.example.tractorificare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private String user, name, city;
    private TextView nameView, cityView;
    private Button logOut, home;
    private Intent logInActivity, feedActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameView = findViewById(R.id.userName);
        cityView = findViewById(R.id.userCity);
        logOut = findViewById(R.id.logOutBtn);
        logOut.setOnClickListener(this);
        home = findViewById(R.id.homeBtn);
        home.setOnClickListener(this);
        logInActivity = new Intent(this, LoginActivity.class);
        feedActivity = new Intent(this, ActivityFeed.class);

        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore.getInstance()
                .collection("Users")
                .document(user).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    name = document.getData().get("name").toString();
                    city = document.getData().get("city").toString();
                    nameView.setText(name);
                    cityView.setText(city);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.logOutBtn):
                FirebaseAuth.getInstance().signOut();
                startActivity(logInActivity);
            case (R.id.homeBtn):
                startActivity(feedActivity);
        }
    }
}