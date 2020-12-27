package com.example.android.movieadapter2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.movieadapter2.Data.source.local.entity.Movie;
import com.example.android.movieadapter2.Detail.DetailActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    private final Activity activity;
    private List<Movie> mCourses = new ArrayList<>();

    public ListMovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Movie> getListCourses() {
        return mCourses;
    }
    void setListCourses(List<Movie> listCourses) {
        if (listCourses == null) return;
        this.mCourses.clear();
        this.mCourses.addAll(listCourses);
    }


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListMovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movie, parent, false);
        return new ListViewHolder(view);

    }

    @Override

    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {


        holder.tvName.setText(getListCourses().get(position).getTitle());
        holder.tvRelease.setText(getListCourses().get(position).getRelease());
        String url_image = "https://image.tmdb.org/t/p/w185" + getListCourses().get(position).getMovieBg();

        GlideApp.with(holder.itemView.getContext())
                .load(url_image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE, getListCourses().get(position).getId());
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        final public ImageView imgPhoto;
        final public TextView tvName;
        final public TextView tvRelease;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.blackBg);
            tvName = itemView.findViewById(R.id.homeTitle);
            tvRelease = itemView.findViewById(R.id.homeRelease);
        }

    }
}
