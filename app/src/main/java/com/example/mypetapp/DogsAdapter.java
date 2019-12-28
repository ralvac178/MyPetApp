package com.example.mypetapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.MyViewHolder> {

    ArrayList<Dogs> dogsArrayList;
    Activity activity;

    public DogsAdapter(ArrayList<Dogs> dogsArrayList, Activity activity) {
        this.dogsArrayList = dogsArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    //Inflar el layout con los elementos a través del recyclerview
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Dogs dogs = dogsArrayList.get(position);
        holder.mLikeDog.setText(""+dogs.getLikes());
        holder.mNameDog.setText(dogs.getName());
        holder.mPhotoDog.setImageResource(dogs.getPhotoID());

        holder.mHuesoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int likes = dogs.getLikes();
                if(likes == 0){
                    holder.mLikeDog.setText(""+1);
                    dogs.setLikes(1);
                }
                else if(likes == 1){
                    holder.mLikeDog.setText(""+0);
                    dogs.setLikes(0);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dogsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mPhotoDog, mHuesoLike;
        TextView mNameDog, mLikeDog;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mPhotoDog = itemView.findViewById(R.id.iv_dogs);
            mNameDog = itemView.findViewById(R.id.tv_nombre_perro);
            mLikeDog = itemView.findViewById(R.id.tv_nro_perro);
            mHuesoLike = itemView.findViewById(R.id.iv_hueso_perro_like);
        }
    }
}
