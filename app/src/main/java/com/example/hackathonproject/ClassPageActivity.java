package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ClassPageActivity extends AppCompatActivity implements AssignmentListViewAdapter.ItemClickListener{

    AssignmentListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_page);

        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("class_name");
        String[] assignmentValues = bundle.getStringArray("assignments");
        System.out.print(value);


        // data to populate the RecyclerView with
        ArrayList<String> assignmentNames = new ArrayList<>();
        for(String a: assignmentValues) {
            assignmentNames.add(a);
        }


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listOfAssignments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AssignmentListViewAdapter(this, assignmentNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    // This is what the adapter calls
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, UploadWork.class);
        intent.putExtra("class_name", adapter.getItem(position));
        startActivity(intent);
    }
}
