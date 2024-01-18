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

public class DetailFilmActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailGenre, detailCreator, detailActor;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        detailGenre = findViewById(R.id.detailGenre);
        detailCreator = findViewById(R.id.detailCreator);
        detailActor = findViewById(R.id.detailActor);

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFilmActivity();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailGenre.setText(bundle.getString("Genre"));
            detailCreator.setText(bundle.getString("Creator"));
            detailActor.setText(bundle.getString("Actor"));

            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Film");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailFilmActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
            }
        });
    }

    public void openFilmActivity(){
        Intent intent = new Intent(this, FilmActivity.class);
        startActivity(intent);
    }
}