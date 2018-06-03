package com.example.viachslav.phonecatalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


//создаем массив разделов
    private String titles[] = {
            "Iphone 3G",
            "Iphone 4",
            "Iphone 4S",
            "Iphone 5",
            "Iphone 5S",
            "Iphone 6",
            "Iphone 6S",
            "Iphone 6S Plus",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);
        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);

                intent.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intent);

            }
        }
        );
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                }
                switch (id) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, getString(R.string.action_settings), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, getString(R.string.action_search), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_favorites:
                        Toast.makeText(MainActivity.this, getString(R.string.action_favorites), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_recent:
                        Toast.makeText(MainActivity.this, getString(R.string.action_recent), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_item3:
                        Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }

        }

