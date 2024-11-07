package com.example.myrecyclerviewcardview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {

    private final Activity mContext;
    private final List<Animal> mAnimals;

    public AnimalsAdapter(Activity mContext, List<Animal> mAnimals) {
        this.mAnimals = mAnimals;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.image.setImageResource(animal.getImageDrawable());
        holder.name.setText(animal.getName());
        holder.info.setText(animal.getInfo());
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        View rootView;
        ImageView image;
        TextView name;
        TextView info;

        public VH(@NonNull View itemView, Context context) {
            super(itemView);
            rootView = itemView;
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
        }
    }
}
