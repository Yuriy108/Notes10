package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Note> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        list.add(new Note("Учеба ","Посещение заняти по Андроид","понедельник",1));
        list.add(new Note("Учеба ","Посещение заняти по Андроид","четверг",1));
        list.add(new Note("Магазин","Купить тушенку","среда",2));
        list.add(new Note("Отдых ","Поездка на лыжи","суббота",3));
        list.add(new Note("Дача ","Утеплить дом","воскресенье",2));
        list.add(new Note("Спорт ","Участие в турнире по футболу","вторник",1));
        Noteadapter noteadapter=new Noteadapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteadapter);
    }
}