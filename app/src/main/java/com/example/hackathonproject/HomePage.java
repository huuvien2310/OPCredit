package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String[] array = {"Art",
            "Business Ad",
            "Biology",
            "Communications",
            "Criminal Justice",
            "Computer Science",
            "School Leadership",
            "Economics",
            "Education",
            "Psychology",
            "French",
            "Health Education",
            "History",
            "Journalism",
            "Occupational therapy",
            "Theatre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);

        listView = findViewById(R.id.course);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(HomePage.this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String course = listView.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "Clicked: " + course, Toast.LENGTH_SHORT).show();
    }
}
