package com.udacity.gradle.builditbigger;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.udacity.gradle.builditbigger.utils.APPConstant;
import java.util.ArrayList;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeAdapterViewHolder> {
    ArrayList<String> jokesArray;
    private LayoutInflater layoutInflater;

    public JokeAdapter(ArrayList<String> jokes){
        this.jokesArray = jokes;
    }

    @NonNull
    @Override
    public JokeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false);
        return new JokeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeAdapterViewHolder holder, int position) {
        String jokeString = jokesArray.get(position);
        Log.d(APPConstant.DEBUG_TAG, "current joke in the array" + jokeString);
        holder.jokeTextView.setText(jokeString);
    }

    @Override
    public int getItemCount() {
        return jokesArray.size();
    }

    public class JokeAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView jokeTextView;

        public JokeAdapterViewHolder(View view){
            super(view);
            jokeTextView = view.findViewById(R.id.jokeDescriptionTextView);
        }
    }
}
