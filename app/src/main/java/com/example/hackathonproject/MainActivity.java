package com.example.hackathonproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Define the UI elements */
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    String userName = "Admin";
    String userPassword = "123456";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Bind the XML views to Java Code Elements */
        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);

        /* Describe the logic when the login button is clicked */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Obtain user inputs */
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                /* Check if the user inputs are empty */
                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    /* Display a message toast to user to enter the details */
                    Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_SHORT).show();

                }else {

                    /* Validate the user inputs */
                    isValid = validate(inputName, inputPassword);
                    /* Validate the user inputs */

                    /* If not valid */
                    if (!isValid) {
                        Toast.makeText(MainActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_SHORT).show();
                    }
                    /* If valid */
                    else {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        /* Allow the user into the app by going into the next activity */
                        Intent intent = new Intent(MainActivity.this, AssignmentList.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    /* Validate the credentials */
    private boolean validate(String name, String password)
    {
        /* Check the credentials */
        if(name.equals(userName) && password.equals(userPassword)){
            return true;
        }
        return false;
    }
}