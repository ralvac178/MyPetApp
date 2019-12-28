package com.example.mypetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RatePets extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Dogs> dogsArrayList = new ArrayList<>();
    ArrayList<Dogs> dogsRatesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_pets);

        Toolbar toolbar = findViewById(R.id.myRateToolbar);
        toolbar.setTitle("Petagram");
        toolbar.setTitleMarginStart(52);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        dogsArrayList = null;

        Bundle paramters = getIntent().getExtras();
        if(paramters!=null) {
            dogsArrayList = (ArrayList<Dogs>) paramters.getSerializable("bundleDogs");
        }



        for(int i = 0; i < dogsArrayList.size();i++){
            if (dogsArrayList.get(i).getLikes() == 1){
                dogsRatesArrayList.add(new Dogs(dogsArrayList.get(i).getName(),dogsArrayList.get(i).getLikes(),dogsArrayList.get(i).getPhotoID()));
            }
        }


        recyclerView = findViewById(R.id.rv_ratesDogs);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(llm);

        DogsAdapter dogsAdapter = new DogsAdapter(dogsRatesArrayList,this);
        recyclerView.setAdapter(dogsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(RatePets.this, MainActivity.class);
                startActivity(intent);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
