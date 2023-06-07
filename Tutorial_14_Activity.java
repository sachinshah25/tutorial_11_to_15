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
import java.util.Map;
import java.util.Set;

public class Tutorial_14_Activity extends AppCompatActivity {
    ActivityTutorial13Binding binding; // Using Binding Featues
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial13Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences=getSharedPreferences("details",MODE_PRIVATE);
        editor=sharedPreferences.edit();

//        binding.add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Set<String> fruits=sharedPreferences.getStringSet("Fruits",null);
//                ArrayList<String> arrayList=new ArrayList<>();
//                for (String fruit:fruits){
//                    arrayList.add(fruit);
//                }
//                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
//                binding.listView.setAdapter(arrayAdapter);
//            }
//        });
//
       // get All Value From SharePreferences In Map
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> arrayList=new ArrayList<>();
                Map<String,?> map=sharedPreferences.getAll();
                for (Map.Entry<String,?> data:map.entrySet()){
                    arrayList.add(data.getValue().toString());
                }

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                binding.listView.setAdapter(arrayAdapter);

                // Let's run
                // Thaks For Watching

            }
        });
    }
}