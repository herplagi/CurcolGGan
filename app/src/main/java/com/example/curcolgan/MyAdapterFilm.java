package com.example.curcolgan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterFilm extends RecyclerView.Adapter<MyViewHolderFilm> {

    private Context context;
    private List<DataClassFilm> dataList;

    public MyAdapterFilm(Context context, List<DataClassFilm> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderFilm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_film, parent, false);
        return new MyViewHolderFilm(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderFilm holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailFilmActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Genre", dataList.get(holder.getAdapterPosition()).getDataGenre());
                intent.putExtra("Creator", dataList.get(holder.getAdapterPosition()).getDataCreator());
                intent.putExtra("Actor", dataList.get(holder.getAdapterPosition()).getDataActor());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClassFilm> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolderFilm extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recGenre, recCreator, recActor;
    CardView recCard;

    public MyViewHolderFilm(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recDesc = itemView.findViewById(R.id.recDesc);
        recTitle = itemView.findViewById(R.id.recTitle);

    }
}