package com.example.picturehomework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

 class DownloadImage extends AsyncTask<String, Void, Bitmap> {
     ImageView picture;

     public DownloadImage(ImageView picture) {
         this.picture = picture;
     }

     public DownloadImage() {

     }

     protected Bitmap doInBackground(String... urls) {
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
         picture.setImageBitmap(png);


         return png;
     }

     protected void onPostExecute(Bitmap result) {
         picture.setImageBitmap(result);
     }
 }
