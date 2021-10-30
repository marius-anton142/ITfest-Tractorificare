package com.example.tractorificare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView goToLoginBtn;
    private EditText nameInput, emailInput, passwordInput, cityInput;
    private ProgressBar progressBar;
    private Button registerBtn;
    private FirebaseAuth mAuth;
    private Intent profileActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        goToLoginBtn = findViewById(R.id.goToLogin);
        goToLoginBtn.setOnClickListener(this);

        nameInput = findViewById(R.id.nameReg);
        emailInput = findViewById(R.id.emailReg);
        passwordInput = findViewById(R.id.passwordReg);
        cityInput = findViewById(R.id.cityReg);

        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);

        progressBar = findViewById(R.id.progressBar);

        profileActivity = new Intent(this, ProfileActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goToLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.registerBtn:
                registerUser();
                System.out.println("ok bro");
                break;
        }
    }

    private void registerUser() {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String city = cityInput.getText().toString().trim();

        if (name.isEmpty()) {
            nameInput.setError("Name is required");
            nameInput.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            emailInput.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Gimme good email");
            emailInput.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            passwordInput.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordInput.setError("Gimme more than 6 dumb ass characters");
            passwordInput.requestFocus();
            return;
        }

        if (city.isEmpty()) {
            cityInput.setError("City is required");
            passwordInput.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Map<String, Object> user = new HashMap<>();
                            user.put("name", name);
                            user.put("email", email);
                            user.put("city", city);
                            FirebaseFirestore.getInstance()
                                    .collection("Users")
                                    .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .set(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(profileActivity);
                                    }
                                    else {
                                        Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                    }
                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}