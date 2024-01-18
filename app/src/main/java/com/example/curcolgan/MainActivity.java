package com.example.curcolgan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView moodImage;
    private ImageView postImage;
    private ImageView filmImage;
    private ImageView quoteImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodImage = (ImageView) findViewById(R.id.moodImage);
        postImage = (ImageView) findViewById(R.id.postImage);
        filmImage = (ImageView) findViewById(R.id.filmImage);
        quoteImage = (ImageView) findViewById(R.id.quoteImage);

        moodImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMoodActivity();
            }
        });

        postImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPostActivity();
            }
        });

        filmImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFilmActivity();
            }
        });

        quoteImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openQuotesActivity();
            }
        });
    }
    public void openMoodActivity(){
        Intent intent = new Intent(this, MoodActivity.class);
        startActivity(intent);
    }

    public void openPostActivity(){
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    public void openFilmActivity(){
        Intent intent = new Intent(this, FilmActivity.class);
        startActivity(intent);
    }

    public void openQuotesActivity(){
        Intent intent = new Intent(this, QuotesActivity.class);
        startActivity(intent);
    }
}
