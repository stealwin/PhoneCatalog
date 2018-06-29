package com.example.viachslav.phonecatalog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        WebView webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        // получаем строку и формируем имя ресурса
        String resName = "n" + intent.getIntExtra("title",0);
        Log.i("name",resName);
        Context context = getBaseContext(); // получаем контекст
        // читаем текстовый файл из ресурсов по имени
        String text = readRawTextFile(context, getResources().getIdentifier(resName,
                "raw", "com.example.viachslav.phonecatalog"));
        webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null);
    }
  private String readRawTextFile (Context context, int resId) {
      InputStream inputStream = context.getResources().openRawResource(resId);
      InputStreamReader inputReader = new InputStreamReader(inputStream);
      BufferedReader buffReader = new BufferedReader(inputReader);
      String line;
      StringBuilder builder = new StringBuilder();
      try {
          while ((line = buffReader.readLine()) != null) {
              builder.append(line);
              builder.append("\n");

          }

      } catch (IOException e) {
          return null;
      }
      return builder.toString();
      }
}
