package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AddMenu(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "메뉴의 정보를 입력해주세요", Toast.LENGTH_SHORT).show();
    }

    public void QustionMenu(View view) {
        Intent intent = new Intent(MainActivity.this, QustionActivity.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "원하는 메뉴의 정보를 입력해주세요", Toast.LENGTH_SHORT).show();
    }
}
