package com.example.multiactivitycats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CatDetails extends AppCompatActivity {

    private TextView longDescription = null;
    private TextView searchWebButton = null;
    private Cat data = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_details);

        longDescription = findViewById(R.id.longDescriptionText);
        searchWebButton = findViewById(R.id.searchMoreWebbtn);

        Intent intent = getIntent();
        data = (Cat) intent.getExtras().getSerializable("data");

        longDescription.setText(data.getDescription());
        searchWebButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = data.getMoreInfourl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}