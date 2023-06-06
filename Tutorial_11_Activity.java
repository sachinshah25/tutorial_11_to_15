package com.example.image.tutorial_10_to_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.image.R;
import com.example.image.databinding.ActivityTutorial11Binding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tutorial_11_Activity extends AppCompatActivity {

    ActivityTutorial11Binding binding;  // For Using Binding Feature
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorial11Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable=getApplicationContext().getDrawable(R.drawable.image6);
                BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
                Bitmap bitmap=bitmapDrawable.getBitmap();

                FileOutputStream  fileOutputStream=null;
                File file=new File(getExternalCacheDir(),"OneImage.jpeg");
                try {
                     fileOutputStream=new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,80,fileOutputStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Uri uri=Uri.fromFile(file);
                binding.img.setImageURI(uri);

                // Let's Run
                // Thanks For Watching

            }
        });
    }
}