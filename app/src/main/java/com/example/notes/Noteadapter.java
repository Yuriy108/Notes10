package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Noteadapter extends RecyclerView.Adapter<Noteadapter.NoteViewHolder> {
    private ArrayList<Note> notes;

    public Noteadapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note=notes.get(position);
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDascription.setText(note.getDescription());
        holder.textViewDayOfWeek.setText(note.getDayOfWeek());
        int colorId;
        int priority=note.getPriority();
        switch (priority){
            case 1:colorId=holder.itemView.getResources().getColor(android.R.color.holo_red_light); break;
            case 2:colorId=holder.itemView.getResources().getColor(android.R.color.holo_blue_bright);break;
            default:colorId=holder.itemView.getResources().getColor(android.R.color.holo_green_light);
        }
        holder.textViewTitle.setBackgroundColor(colorId);




    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDascription;
        TextView textViewDayOfWeek;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDascription=itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek=itemView.findViewById(R.id.textViewDayOfweek);

        }
    }

}
