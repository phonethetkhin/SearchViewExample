package com.example.searchviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    List<AnimalNames> animallist;
    ArrayList<AnimalNames> animalNamesArrayList=new ArrayList<>();

    public AnimalAdapter(List<AnimalNames> animallist) {
        this.animallist = animallist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.animallistitem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tvAnimalName.setText("Animal :"+animallist.get(position).getAnimalName());
    }

    @Override
    public int getItemCount() {
        return animallist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAnimalName;
        public ViewHolder(@NonNull View v) {
            super(v);
            tvAnimalName=v.findViewById(R.id.tvAnimalName);

        }
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        animallist.clear();
        if (charText.length() == 0) {
            animallist.addAll(animalNamesArrayList);
        } else {
            for (AnimalNames wp : animalNamesArrayList) {
                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    animallist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
