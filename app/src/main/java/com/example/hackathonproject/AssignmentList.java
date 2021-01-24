package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AssignmentList extends AppCompatActivity implements ClassListViewAdapter.ItemClickListener{


    ClassListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist_activity);

        // data to populate the RecyclerView with
        ArrayList<String> classNames = new ArrayList<>();
        classNames.add("Art");
        classNames.add("Business");
        classNames.add("Biology");
        classNames.add("Communications");
        classNames.add("Criminal Justice");
        classNames.add("Computer Science");
        classNames.add("Economics");
        classNames.add("Education");
        classNames.add("Psychology");
        classNames.add("French");
        classNames.add("Health Education");
        classNames.add("History");
        classNames.add("Journalism");
        classNames.add("Theatre");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listOfClasses);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClassListViewAdapter(this, classNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    // This is what the adapter calls
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + (position + 1), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ClassPageActivity.class);
        intent.putExtra("class_name", adapter.getItem(position));

        if(adapter.getItem(position).equals("Art")) {
            intent.putExtra("assignments", new String[]{"Draw an egg"});
        }
        else if(adapter.getItem(position).equals("Business")){
            intent.putExtra("assignments", new String[]{"What is Entrepreneurship"});
        }
        else if(adapter.getItem(position).equals("Biology")){
            intent.putExtra("assignments", new String[]{"Summary the article \"Sex Limited Inheritance in Drosophila\", by Thomas Hunt Morgan"});
        }
        else if(adapter.getItem(position).equals("Communications")){
            intent.putExtra("assignments", new String[]{"Explain why some games offered free-to-play, or freemium"});
        }
        else if(adapter.getItem(position).equals("Criminal Justice")){
            intent.putExtra("assignments", new String[]{"Describe the U.S. criminal justice system"});
        }
        else if(adapter.getItem(position).equals("Computer Science")) {
            intent.putExtra("assignments", new String[]{"Create a Hello World App", "Simulate the solar system with computer graphics"});
        }
        else if(adapter.getItem(position).equals("Economics")){
            intent.putExtra("assignments", new String[]{"Explain the Auction Theory"});
        }
        else if(adapter.getItem(position).equals("Education")){
            intent.putExtra("assignments", new String[]{"Your Opinion about The Role of The Teacher"});
        }
        else if(adapter.getItem(position).equals("Psychology")){
            intent.putExtra("assignments", new String[]{"How Do Emotions Work?"});
        }
        else if (adapter.getItem(position).equals("French")) {
            intent.putExtra("assignments", new String[]{"Translate A Random French Poem"});
        }
        else if(adapter.getItem(position).equals("Health Education")){
            intent.putExtra("assignments", new String[]{"Explain the Nutrition Pyramid"});
        }
        else if(adapter.getItem(position).equals("History")){
            intent.putExtra("assignments", new String[]{"Explain why Americans were alcoholics in the 1800s"});
        }
        else if(adapter.getItem(position).equals("Journalism")){
            intent.putExtra("assignments", new String[]{"How to avoid Fake News"});
        }
        else if(adapter.getItem(position).equals("Theatre")){
            intent.putExtra("assignments", new String[]{"Your Opinion about the ending of \"La La Land\""});
        }
        startActivity(intent);
    }
}