package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static ArrayList<Note> list= new ArrayList<>();
     Noteadapter noteadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        if(list.isEmpty()){

        list.add(new Note("Учеба ","Посещение заняти по Андроид","понедельник",1));
        list.add(new Note("Учеба ","Посещение заняти по Андроид","четверг",1));
        list.add(new Note("Магазин","Купить тушенку","среда",2));
        list.add(new Note("Отдых ","Поездка на лыжи","суббота",3));
        list.add(new Note("Дача ","Утеплить дом","воскресенье",2));
        list.add(new Note("Спорт ","Участие в турнире по футболу","вторник",1));}
         noteadapter=new Noteadapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteadapter);
        noteadapter.setOnNoteClickListener(new Noteadapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

            }
        });
        ItemTouchHelper itemTouchHelpern= new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                list.remove(viewHolder.getAdapterPosition());
                noteadapter.notifyDataSetChanged();

            }
        });
        itemTouchHelpern.attachToRecyclerView(recyclerView);
    }

    public void newNote(View view) {
        Intent intent =new Intent(this,AddNote.class);
        startActivity(intent);
    }
}