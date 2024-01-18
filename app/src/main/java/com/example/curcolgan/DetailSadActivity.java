package com.example.curcolgan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailSadActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sad);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openArtikelSadActivity();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
    }
    public void openArtikelSadActivity(){
        Intent intent = new Intent(this, ArtikelSadActivity.class);
        startActivity(intent);
    }
}