package com.example.tractorificare;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityFeed extends AppCompatActivity {
    public boolean tap00 = false, tap01 = false, tap02 = false, lerp01, lerp02, lerp00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        //FirebaseDatabase.getInstance("https://tractoristii-98bc8-default-rtdb.europe-west1.firebasedatabase.app")
        //        .getReference("Tests")
        //        .child("Test1")
        //        .setValue(new test("a"));
    }

    public void infoClick00 (View view) {
        Intent intent= new Intent(this,ActivityInfo00.class);
        startActivity(intent);
    }
    public void infoClick01 (View view) {
        Intent intent= new Intent(this,ActivityInfo01.class);
        startActivity(intent);
    }
    public void infoClick02 (View view) {
        Intent intent= new Intent(this,ActivityInfo02.class);
        startActivity(intent);
    }

    public void imageClick00 (View view) {
        if (tap00 == false) {
            tap00 = true;
            lerp00(320);
        } else {
            tap00 = false;
            lerp00(-130);
        }
        if (tap01 == true) {
            tap01 = false;
            lerp01(-200);
        } else if (tap02 == true) {
            tap02 = false;
            lerp02(-230);
        }
    }
    public void imageClick01 (View view) {
        if (tap01 == false) {
            tap01 = true;
            lerp01(350);
        } else {
            tap01 = false;
            lerp01(-210);
        }
        if (tap00 == true) {
            tap00 = false;
            lerp00(-130);
        } else if (tap02 == true) {
            tap02 = false;
            lerp02(-230);
        }
    }
    public void imageClick02 (View view) {
        if (tap02 == false) {
            tap02 = true;
            lerp02(380);
        } else {
            tap02 = false;
            lerp02(-250);
        }
        if (tap01 == true) {
            tap01 = false;
            lerp01(-200);
        } else if (tap00 == true) {
            tap00 = false;
            lerp00(-130);
        }
    }
    public void lerp00(int dist) {
        ImageView imgEat = findViewById(R.id.imgEat);
        ImageView imgB00 = findViewById(R.id.imgB00), imgB01 = findViewById(R.id.imgB01), imgB02 = findViewById(R.id.imgB02);
        //int[] imgB00Coordinates = new int[2];
        //imgB00.getLocationOnScreen(imgB00Coordinates);
        //imgB00.setY(imgB00.getY() + imgB00.getHeight());
        float initY = imgB00.getY();
        ObjectAnimator animation00 = ObjectAnimator.ofFloat(imgB00, "translationY", dist);
        ObjectAnimator animation01 = ObjectAnimator.ofFloat(imgB01, "translationY", dist);
        ObjectAnimator animation02 = ObjectAnimator.ofFloat(imgB02, "translationY", dist);
        animation00.setDuration(180);
        animation00.start();
        animation01.setDuration(300);
        animation01.start();
        animation02.setDuration(420);
        animation02.start();
    }
    public void lerp01(int dist) {
        ImageView imgVisit = findViewById(R.id.imgVisit);
        ImageView imgB10 = findViewById(R.id.imgB10), imgB11 = findViewById(R.id.imgB11), imgB12 = findViewById(R.id.imgB12);
        float initY = imgB10.getY();
        ObjectAnimator animation00 = ObjectAnimator.ofFloat(imgB10, "translationY", dist);
        ObjectAnimator animation01 = ObjectAnimator.ofFloat(imgB11, "translationY", dist);
        ObjectAnimator animation02 = ObjectAnimator.ofFloat(imgB12, "translationY", dist);
        animation00.setDuration(200);
        animation00.start();
        animation01.setDuration(300);
        animation01.start();
        animation02.setDuration(420);
        animation02.start();
    }
    public void lerp02(int dist) {
        ImageView imgLaw = findViewById(R.id.imgLaw);
        ImageView imgB20 = findViewById(R.id.imgB20), imgB21 = findViewById(R.id.imgB21), imgB22 = findViewById(R.id.imgB22);
        float initY = imgB20.getY();
        ObjectAnimator animation00 = ObjectAnimator.ofFloat(imgB20, "translationY", dist);
        ObjectAnimator animation01 = ObjectAnimator.ofFloat(imgB21, "translationY", dist);
        ObjectAnimator animation02 = ObjectAnimator.ofFloat(imgB22, "translationY", dist);
        animation00.setDuration(200);
        animation00.start();
        animation01.setDuration(300);
        animation01.start();
        animation02.setDuration(420);
        animation02.start();
    }
}
