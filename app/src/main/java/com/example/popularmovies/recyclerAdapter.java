package com.example.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.CookieHandler;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    private ArrayList<Movie> movieList;

    private Context context ;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.rating.setText(movie.getRating().toString());
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());

        Picasso.get().load(movie.getPoster()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView rating;
        TextView overview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.movie_title);
            rating = itemView.findViewById(R.id.movie_rating);
            overview = itemView.findViewById(R.id.overview);

        }
    }
}
