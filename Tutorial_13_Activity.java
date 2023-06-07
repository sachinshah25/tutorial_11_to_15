package com.example.image.tutorial_10_to_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.image.databinding.ActivityTutorial13Binding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tutorial_13_Activity extends AppCompatActivity {

    ActivityTutorial13Binding binding;  // Using Binding Features
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial13Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences=getSharedPreferences("setData",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        // put Set Data in Shared Preferences
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // put Values using set
                Set<String> setData=new HashSet<>();
                setData.add("Apple");
                setData.add("Mango");
                setData.add("Orange");
                setData.add("Grapes");
                setData.add("Banana");

                editor.putStringSet("Fruits",setData);
                editor.apply();  //  SAve DAta

                // Read Data
                // Let's Run
                Set<String> fruits=sharedPreferences.getStringSet("Fruits",null);
                ArrayList<String> arrayList=new ArrayList<>();
                for (String fruit:fruits){
                    arrayList.add(fruit);
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                binding.listView.setAdapter(arrayAdapter);

                // Thanks For Watching
            }
        });
    }
}