package com.example.tractorificare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View view) {
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setQueryHint("scrie ceva aici");
        searchView.setOnQueryTextListener("aba");
    }
}
