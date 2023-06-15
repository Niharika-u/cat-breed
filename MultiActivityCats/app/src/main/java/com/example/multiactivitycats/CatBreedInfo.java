package com.example.multiactivitycats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class CatBreedInfo extends AppCompatActivity {

    private TextView size = null;
    private TextView eyeColor = null;
    private TextView foundIn = null;
    private TextView furType = null;
    private ImageView catImage = null;
    private Button moreInfoBT = null;

    //data
    private Cat data = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_breed_info);

        size = findViewById(R.id.catSize);
        eyeColor = findViewById(R.id.eyeColor);
        foundIn = findViewById(R.id.foundIn);
        furType = findViewById(R.id.furType);
        catImage = findViewById(R.id.catimage2);
        moreInfoBT = findViewById(R.id.moreinfobtn);

        Intent intent = getIntent();
        data = (Cat) intent.getExtras().getSerializable("data");

        size.setText(data.getSize());
        eyeColor.setText(data.getEyeColor());
        foundIn.setText(data.getFoundIn());
        furType.setText(data.getFurType());
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageId = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        catImage.setImageResource(imageId);

        try {
            catImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer music = MediaPlayer.create(CatBreedInfo.this, R.raw.cat_song);
                    music.start();
                }
            });
        } catch (Exception e) {

        }


        moreInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatBreedInfo.this, CatDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}