package com.example.curcolgan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class DetailQuotesActivity extends AppCompatActivity {

    TextView detailPencipta, detailQuote;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quotes);

        detailPencipta = findViewById(R.id.detailPencipta);
        detailImage = findViewById(R.id.detailImage);
        detailQuote = findViewById(R.id.detailQuote);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailPencipta.setText(bundle.getString("Pencipta"));
            detailQuote.setText(bundle.getString("Quote"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
    }
}