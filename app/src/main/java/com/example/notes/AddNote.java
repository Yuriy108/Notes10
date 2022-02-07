package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNote extends AppCompatActivity {
    EditText editTextTitle;
    EditText editTextDescription;
    Spinner spinner;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle=findViewById(R.id.editTextTitle);
        editTextDescription=findViewById(R.id.editTextDescription);
        spinner=findViewById(R.id.spinner);
        radioGroup=findViewById(R.id.radio);
    }

    public void addNote(View view) {
        String title=editTextTitle.getText().toString().trim();
        String des=editTextDescription.getText().toString().trim();
        String dayOfWeek=spinner.getSelectedItem().toString();
        int RadioButton=radioGroup.getCheckedRadioButtonId();
        android.widget.RadioButton radioButton=findViewById(RadioButton);
        int priority=Integer.parseInt(radioButton.getText().toString());
        Note newNote=new Note(title,des,dayOfWeek,priority);
        MainActivity.list.add(newNote);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}