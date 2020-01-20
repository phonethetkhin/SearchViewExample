package com.example.searchviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;
    android.widget.SearchView svMain;
    String[] animalist;
    List<AnimalNames> Animallist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain=findViewById(R.id.rvMain);
        svMain=findViewById(R.id.svMain);

        animalist = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey"};

        for (int i = 0; i < animalist.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalist[i]);
            // Binds all strings into an array
            Animallist.add(animalNames);
        }



        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
        rvMain.setHasFixedSize(true);
        final AnimalAdapter adapter=new AnimalAdapter(Animallist);
        rvMain.setAdapter(adapter);

       svMain.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               String text=newText;
               adapter.filter(text);
               return false;
           }
       });
    }
}
