package com.example.image.tutorial_10_to_20;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.image.R;
import com.example.image.databinding.ActivityTutorial13Binding;
import com.example.image.databinding.ActivityTutorial15Binding;
import com.example.image.modelClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tutorial_15_Activity extends AppCompatActivity {
    ActivityTutorial15Binding binding; // For Using Binding Features
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTutorial15Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("setData", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        binding.addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch("image/*");
            }
        });
        //  Thamks For WAtching
        binding.setImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<String> strings=sharedPreferences.getStringSet("ImageUri",null);
                ArrayList<String> arrayList=new ArrayList<>();
                for (String uri:strings){
                    arrayList.add(uri);
                }
                binding.imageRecyclerView.setLayoutManager(new GridLayoutManager(Tutorial_15_Activity.this,2));
                modelClass modelClass=new modelClass(arrayList,getApplicationContext());
                binding.imageRecyclerView.setAdapter(modelClass);

            }
        });

    }
    ActivityResultLauncher<String> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> result) {
                 Set<String> set=new HashSet<>();
                 for (Uri uri:result){
                     set.add(uri.toString());
                 }
                 editor.putStringSet("ImageUri",set);
                 editor.apply(); // Save DAta
            // Lets Run
            // Again Run
        }
    });

}