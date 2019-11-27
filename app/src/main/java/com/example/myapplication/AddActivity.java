package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.effect.Effect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {
    public EditText name;
    public Spinner type;
    public Spinner isspicy;
    public Spinner isprice;
    public Spinner issoup;
    public Spinner isfast;
    public Spinner ismeat;
    public Spinner isrice;
    public Spinner ishot;
    public Spinner isheavy;
    public Spinner isfried;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void postdata(View view) {
        name = (EditText)findViewById(R.id.editText12);
        type = (Spinner)findViewById(R.id.spinner);
        isspicy = (Spinner)findViewById(R.id.spinner2);
        isprice = (Spinner)findViewById(R.id.spinner3);
        issoup = (Spinner)findViewById(R.id.spinner4);
        isfast = (Spinner)findViewById(R.id.spinner5);
        ismeat = (Spinner)findViewById(R.id.spinner6);
        isheavy = (Spinner)findViewById(R.id.spinner7);
        ishot = (Spinner)findViewById(R.id.spinner8);
        isrice = (Spinner)findViewById(R.id.spinner9);
        isfried = (Spinner)findViewById(R.id.spinner10);

        HashMap<String, String> input = new HashMap<>();
        input.put("food_name", name.getText().toString());
        input.put("food_type", type.getSelectedItem().toString());
        input.put("food_isspicy", isspicy.getSelectedItem().toString());
        input.put("food_isprice", isprice.getSelectedItem().toString());
        input.put("food_issoup", issoup.getSelectedItem().toString());
        input.put("food_isfast", isfast.getSelectedItem().toString());
        input.put("food_ismeat", ismeat.getSelectedItem().toString());
        input.put("food_isrice", isrice.getSelectedItem().toString());
        input.put("food_ishot", ishot.getSelectedItem().toString());
        input.put("food_isheavy", isheavy.getSelectedItem().toString());
        input.put("food_isfried", isfried.getSelectedItem().toString());

        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        retrofitService.postData(input).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()) {
                    Data body = response.body();
                    if(body != null) {
                        Toast.makeText(getApplicationContext(), "메뉴가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "메뉴가 저장되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void back(View view) {
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
