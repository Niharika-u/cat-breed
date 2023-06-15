package com.example.multiactivitycats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CatActivity extends AppCompatActivity {


    private RecyclerView catList = null;
    ArrayList<Cat> cats = new ArrayList<>();
    CatFromXml catFromXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        catList = findViewById(R.id.catList);
        catFromXml = new CatFromXml(this);
        cats = catFromXml.getAllCats();

        CatAdapter adapter = new CatAdapter(cats);
        catList.setAdapter(adapter);
        catList.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(new CatAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(CatActivity.this, CatBreedInfo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", cats.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}