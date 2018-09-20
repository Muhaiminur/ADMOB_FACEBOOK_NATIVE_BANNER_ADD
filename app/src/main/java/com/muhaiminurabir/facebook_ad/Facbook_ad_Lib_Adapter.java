package com.muhaiminurabir.facebook_ad;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Facbook_ad_Lib_Adapter extends RecyclerView.Adapter<Facbook_ad_Lib_Adapter.MovieHolder> {

    private List<String> moviesList;

    public Facbook_ad_Lib_Adapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.facebook_native_lib, parent, false);

        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        String movie = moviesList.get(position);
        //MovieHolder moveHolder = (MovieHolder) holder;
        //moveHolder.sh.setText(movie);
        holder.sh.setText(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public static class MovieHolder extends RecyclerView.ViewHolder {
        public TextView sh;

        public MovieHolder(View view) {
            super(view);
            sh=view.findViewById(R.id.sample_name);
        }
    }
}