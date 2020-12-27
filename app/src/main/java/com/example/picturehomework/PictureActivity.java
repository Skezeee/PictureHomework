package com.example.picturehomework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PictureActivity extends AppCompatActivity {
    ImageView picture;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info = findViewById(R.id.textView);
        picture = findViewById(R.id.imageView);
        DownLoadImage downLoadImage =new DownLoadImage();
        downLoadImage.execute();
    }

class DownLoadImage extends AsyncTask<String,Void,Bitmap >{
        public DownLoadImage(){

        }
    public Bitmap doInBackground(String... urls) {
        URL url = null;
        try {
            url = new URL("https://images.izi.ua/9687268");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap png = null;
        try {
            png = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return png;
    }

    protected void onPostExecute(Bitmap result) {
        picture.setImageBitmap(result);
    }
}
}
