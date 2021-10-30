package com.example.tractorificare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   /***
    * variabile pentru bara de catuare
    */
   ///bara
    SearchView searchView;
    //lista de elemente ce va fi afisata
    ListView listView;
    ///valorile ce vor fi introdude in listView
    ArrayList<String> listaOrase= new ArrayList<String>();
    ///adapter, un fel de mijlocitor intre cod si listView
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.list_view);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaOrase);
        listView.setAdapter(adapter);

        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setQueryHint("scrie ceva aici");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(listaOrase.contains(query)){
                    adapter.getFilter().filter(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        }


      /*  public void searchBarVisibility(View view){
        ListView searchBar= (ListView) findViewById(R.id.list_view);
        searchBar.setVisibility(0);
        }*/
    }












