package com.example.image.tutorial_10_to_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.image.R;
import com.example.image.databinding.ActivityTutorial12Binding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tutorial_12_Activity extends AppCompatActivity {

    ActivityTutorial12Binding binding; // For using Binding features
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Write Data in SharePreferences`
        // Let's run
        sharedPreferences=getSharedPreferences("details",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("One","1");
        editor.putString("Two","2");
        editor.putString("Three","3");
        editor.putString("Four","4");
        editor.apply();

        // now read data
        binding.read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tutorial_12_Activity.this, ""+sharedPreferences.getString("One",null), Toast.LENGTH_SHORT).show();
                Toast.makeText(Tutorial_12_Activity.this, ""+sharedPreferences.getString("Two",null), Toast.LENGTH_SHORT).show();
                Toast.makeText(Tutorial_12_Activity.this, ""+sharedPreferences.getString("Three",null), Toast.LENGTH_SHORT).show();
                Toast.makeText(Tutorial_12_Activity.this, ""+sharedPreferences.getString("Four",null), Toast.LENGTH_SHORT).show();
            }
        });
        // nor update data
        // lets run
        binding.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Five","5");
                editor.putString("Three","31");
                editor.apply(); // means save
            }
        });
        // now delete
        // let's run
        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // One or Two Delted
                // Because I press two time that's why it run two time
                // and Thaks For watching
                editor.remove("One");
                editor.remove("Two");
                editor.apply();
            }
        });



    }
}