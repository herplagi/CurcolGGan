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

public class MoodActivity extends AppCompatActivity {

    private ImageView sedihImage;
    private ImageView kecewaImage;
    private ImageView galauImage;
    private ImageView cemasImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        sedihImage = (ImageView) findViewById(R.id.sedihImage);
        kecewaImage = (ImageView) findViewById(R.id.kecewaImage);
        galauImage = (ImageView) findViewById(R.id.galauImage);
        cemasImage = (ImageView) findViewById(R.id.cemasImage);

        sedihImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openArtikelSadActivity();
            }
        });

        kecewaImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openArtikelKecewaActivity();
            }
        });

        galauImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openArtikelGalauActivity();
            }
        });

        cemasImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openArtikelCemasActivity();
            }
        });
    }
    public void openArtikelSadActivity(){
        Intent intent = new Intent(this, ArtikelSadActivity.class);
        startActivity(intent);
    }

    public void openArtikelKecewaActivity(){
        Intent intent = new Intent(this, ArtikelKecewaActivity.class);
        startActivity(intent);
    }

    public void openArtikelGalauActivity(){
        Intent intent = new Intent(this, ArtikelGalauActivity.class);
        startActivity(intent);
    }

    public void openArtikelCemasActivity(){
        Intent intent = new Intent(this, ArtikelCemasActivity.class);
        startActivity(intent);
    }
}
