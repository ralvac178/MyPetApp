package com.example.mypetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Dogs> dogsArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    int rate = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        toolbar.setTitle("Petagram");
        toolbar.setTitleMarginStart(52);
        setSupportActionBar(toolbar);

        //Llenado del array o base de datos

        dogsArrayList.add(new Dogs("Bobby",0 ,R.drawable.perrito_bobby));
        dogsArrayList.add(new Dogs("Conan",0,R.drawable.perrito2));
        dogsArrayList.add(new Dogs("Drawly",0,R.drawable.perrito3));
        dogsArrayList.add(new Dogs("Lazy",0,R.drawable.perrito4));
        dogsArrayList.add(new Dogs("Char",0,R.drawable.perrito5));


        recyclerView = findViewById(R.id.rv_recyclerview);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        DogsAdapter mAdapter = new DogsAdapter(dogsArrayList,this);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(MainActivity.this, RatePets.class);
                intent.putExtra("bundleDogs",dogsArrayList);
                startActivity(intent);
                return true;

            case R.id.item2:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
