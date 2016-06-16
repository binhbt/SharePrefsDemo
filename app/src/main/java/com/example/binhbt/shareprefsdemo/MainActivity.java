package com.example.binhbt.shareprefsdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "myapp_prefs";
    public static final String PREFS_COUNT ="count";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View addBtn = findViewById(R.id.btn_add);
        Toast.makeText(this, "Current count ="+getFromPrefs(), Toast.LENGTH_LONG).show();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = getFromPrefs();
                saveToPrefs(++count);
            }
        });
        View currentCount = findViewById(R.id.btn_show);
        currentCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Current count ="+getFromPrefs(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void saveToPrefs(int count){
        SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(PREFS_COUNT, count);
        editor.commit();
    }
    private int getFromPrefs(){
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getInt(PREFS_COUNT, 0);
    }
}
