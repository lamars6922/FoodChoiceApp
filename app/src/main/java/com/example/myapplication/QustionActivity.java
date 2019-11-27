package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Spinner_struct{
    Spinner type;
    Spinner isspicy;
    Spinner isprice;
    Spinner issoup;
    Spinner isfast;
    Spinner ismeat;
    Spinner isrice;
    Spinner ishot;
    Spinner isheavy;
    Spinner isfried;
        }
class String_struct {
    String type_string;
    String spicy_string;
    String price_string;
    String soup_string;
    String fast_string;
    String meat_string;
    String rice_string;
    String hot_string;
    String heavy_string;
    String firied_string;
}
class TextView_struct {
    TextView type_textview;
    TextView spicy_textview;
    TextView price_textview;
    TextView soup_textview;
    TextView fast_textview;
    TextView meat_textview;
    TextView rice_textview;
    TextView hot_textview;
    TextView heavy_textview;
    TextView firied_textview;
}
public class QustionActivity extends AppCompatActivity {

    Spinner_struct spinnerStruct;
    TextView_struct textView;

    ArrayList<String> levelList;
    ArrayList<String> yesOrNoList;
    ArrayList<String> typeList;

    ArrayAdapter<String> levelAdapter;
    ArrayAdapter<String> yesOrNoAdapter;
    ArrayAdapter<String> typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qustion);

        textView = new TextView_struct();
        textView.type_textview = (TextView)findViewById(R.id.nameView12);
        textView.spicy_textview = (TextView)findViewById(R.id.nameView11);
        textView.price_textview = (TextView)findViewById(R.id.nameView10);
        textView.soup_textview = (TextView)findViewById(R.id.nameView9);
        textView.fast_textview = (TextView)findViewById(R.id.nameView8);
        textView.meat_textview = (TextView)findViewById(R.id.nameView7);
        textView.rice_textview = (TextView)findViewById(R.id.nameView6);
        textView.hot_textview = (TextView)findViewById(R.id.nameView5);
        textView.heavy_textview = (TextView)findViewById(R.id.nameView4);
        textView.firied_textview = (TextView)findViewById(R.id.nameView3);

        spinnerStruct = new Spinner_struct();
        spinnerStruct.type = (Spinner)findViewById(R.id.spinner);
        spinnerStruct.isspicy = (Spinner)findViewById(R.id.spinner2);
        spinnerStruct.isprice = (Spinner)findViewById(R.id.spinner3);
        spinnerStruct.issoup = (Spinner)findViewById(R.id.spinner4);
        spinnerStruct.isfast = (Spinner)findViewById(R.id.spinner5);
        spinnerStruct.ismeat = (Spinner)findViewById(R.id.spinner6);
        spinnerStruct.isrice = (Spinner)findViewById(R.id.spinner7);
        spinnerStruct.ishot = (Spinner)findViewById(R.id.spinner8);
        spinnerStruct.isheavy = (Spinner)findViewById(R.id.spinner9);
        spinnerStruct.isfried = (Spinner)findViewById(R.id.spinner10);

        levelList = new ArrayList<>();
        levelList.add(" ");
        levelList.add("상");
        levelList.add("중");
        levelList.add("하");

        yesOrNoList = new ArrayList<>();
        yesOrNoList.add(" ");
        yesOrNoList.add("예");
        yesOrNoList.add("아니오");

        typeList = new ArrayList<>();
        typeList.add(" ");
        typeList.add("한식");
        typeList.add("중식");
        typeList.add("일식");
        typeList.add("양식");

        levelAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                levelList);

        yesOrNoAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                yesOrNoList);

        typeAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                typeList);

        spinnerStruct.type.setAdapter(typeAdapter);
        spinnerStruct.isspicy.setAdapter(levelAdapter);
        spinnerStruct.isprice.setAdapter(levelAdapter);
        spinnerStruct.issoup.setAdapter(yesOrNoAdapter);
        spinnerStruct.isfast.setAdapter(yesOrNoAdapter);
        spinnerStruct.ismeat.setAdapter(yesOrNoAdapter);
        spinnerStruct.isrice.setAdapter(yesOrNoAdapter);
        spinnerStruct.ishot.setAdapter(yesOrNoAdapter);
        spinnerStruct.isheavy.setAdapter(yesOrNoAdapter);
        spinnerStruct.isfried.setAdapter(yesOrNoAdapter);

        spinnerStruct.type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                String value = item.toString();
                Toast.makeText(QustionActivity.this, item.toString(),
                        Toast.LENGTH_SHORT).show();

                switch (value) {
                    case "한식":
                        textView.spicy_textview.setEnabled(true);
                        spinnerStruct.isspicy.setEnabled(true);

                        textView.price_textview.setEnabled(true);
                        spinnerStruct.isprice.setEnabled(true);

                        textView.soup_textview.setEnabled(true);
                        spinnerStruct.issoup.setEnabled(true);

                        textView.fast_textview.setEnabled(false);
                        spinnerStruct.isfast.setEnabled(false);

                        textView.meat_textview.setEnabled(true);
                        spinnerStruct.ismeat.setEnabled(true);

                        textView.rice_textview.setEnabled(true);
                        spinnerStruct.isrice.setEnabled(true);

                        textView.hot_textview.setEnabled(true);
                        spinnerStruct.ishot.setEnabled(true);

                        textView.heavy_textview.setEnabled(true);
                        spinnerStruct.isheavy.setEnabled(true);

                        textView.firied_textview.setEnabled(false);
                        spinnerStruct.isfried.setEnabled(false);
                        break;

                    case "중식":
                        textView.spicy_textview.setEnabled(true);
                        spinnerStruct.isspicy.setEnabled(true);

                        textView.price_textview.setEnabled(true);
                        spinnerStruct.isprice.setEnabled(true);

                        textView.soup_textview.setEnabled(true);
                        spinnerStruct.issoup.setEnabled(true);

                        textView.fast_textview.setEnabled(false);
                        spinnerStruct.isfast.setEnabled(false);

                        textView.meat_textview.setEnabled(true);
                        spinnerStruct.ismeat.setEnabled(true);

                        textView.rice_textview.setEnabled(true);
                        spinnerStruct.isrice.setEnabled(true);

                        textView.hot_textview.setEnabled(true);
                        spinnerStruct.ishot.setEnabled(true);

                        textView.heavy_textview.setEnabled(true);
                        spinnerStruct.isheavy.setEnabled(true);

                        textView.firied_textview.setEnabled(true);
                        spinnerStruct.isfried.setEnabled(true);
                        break;
                    case "일식":
                        textView.spicy_textview.setEnabled(true);
                        spinnerStruct.isspicy.setEnabled(true);

                        textView.price_textview.setEnabled(true);
                        spinnerStruct.isprice.setEnabled(true);

                        textView.soup_textview.setEnabled(true);
                        spinnerStruct.issoup.setEnabled(true);

                        textView.fast_textview.setEnabled(false);
                        spinnerStruct.isfast.setEnabled(false);

                        textView.meat_textview.setEnabled(true);
                        spinnerStruct.ismeat.setEnabled(true);

                        textView.rice_textview.setEnabled(true);
                        spinnerStruct.isrice.setEnabled(true);

                        textView.hot_textview.setEnabled(true);
                        spinnerStruct.ishot.setEnabled(true);

                        textView.heavy_textview.setEnabled(true);
                        spinnerStruct.isheavy.setEnabled(true);

                        textView.firied_textview.setEnabled(true);
                        spinnerStruct.isfried.setEnabled(true);
                        break;
                    case "양식":
                        textView.spicy_textview.setEnabled(true);
                        spinnerStruct.isspicy.setEnabled(true);

                        textView.price_textview.setEnabled(true);
                        spinnerStruct.isprice.setEnabled(true);

                        textView.soup_textview.setEnabled(true);
                        spinnerStruct.issoup.setEnabled(true);

                        textView.fast_textview.setEnabled(true);
                        spinnerStruct.isfast.setEnabled(true);

                        textView.meat_textview.setEnabled(true);
                        spinnerStruct.ismeat.setEnabled(true);

                        textView.rice_textview.setEnabled(true);
                        spinnerStruct.isrice.setEnabled(true);

                        textView.hot_textview.setEnabled(true);
                        spinnerStruct.ishot.setEnabled(true);

                        textView.heavy_textview.setEnabled(true);
                        spinnerStruct.isheavy.setEnabled(true);

                        textView.firied_textview.setEnabled(true);
                        spinnerStruct.isfried.setEnabled(true);
                        break;
                    case " " : default:
                        Toast.makeText(QustionActivity.this, "먹고 싶은 음식 타입을 정해주세요",
                                Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void back(View view) {
        Intent intent = new Intent(QustionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void getData(View view) {

        final String_struct stringStruct= new String_struct();
        stringStruct.type_string = spinnerStruct.type.getSelectedItem().toString();
        stringStruct.spicy_string = spinnerStruct.isspicy.getSelectedItem().toString();
        stringStruct.price_string = spinnerStruct.isprice.getSelectedItem().toString();
        stringStruct.soup_string = spinnerStruct.issoup.getSelectedItem().toString();
        stringStruct.fast_string = spinnerStruct.isfast.getSelectedItem().toString();
        stringStruct.meat_string = spinnerStruct.ismeat.getSelectedItem().toString();
        stringStruct.rice_string = spinnerStruct.isrice.getSelectedItem().toString();
        stringStruct.hot_string = spinnerStruct.ishot.getSelectedItem().toString();
        stringStruct.heavy_string = spinnerStruct.isheavy.getSelectedItem().toString();
        stringStruct.firied_string = spinnerStruct.isfried.getSelectedItem().toString();

        final Data userthink = new Data("", stringStruct.type_string, stringStruct.spicy_string, stringStruct.price_string, stringStruct.soup_string, stringStruct.fast_string,
                stringStruct.meat_string, stringStruct.rice_string, stringStruct.hot_string, stringStruct.heavy_string, stringStruct.firied_string);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getData().enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    List<Data> datas = response.body();
                    List<Data> recommend = matching(datas, userthink);
                    if(datas != null) {
                        Intent intent = new Intent(QustionActivity.this, ResultActivity.class);
                        intent.putExtra("recommend_food", (ArrayList<Data>) recommend);
                        startActivity(intent);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "서버에 이상이 생겼습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public List<Data> matching(List<Data> d, Data data) {
        List<Data> temp = new ArrayList<>();
        List<Data> recommend = new ArrayList<>();
        List<Integer> sumpoint = new ArrayList<>();
        for(int i = 0; i < d.size(); i++)
        {
            if(d.get(i).getFood_type().equals(data.getFood_type()))
            {
                temp.add(d.get(i));
            }
        }
        for(int i = 0; i < temp.size(); i++)
        {
            int point = 0;
            if(temp.get(i).getFood_isspicy().equals(data.getFood_isspicy()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_isprice().equals(data.getFood_isprice()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_issoup().equals(data.getFood_issoup()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_isfast().equals(data.getFood_isfast()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_ismeat().equals(data.getFood_ismeat()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_isrice().equals(data.getFood_isrice()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_ishot().equals(data.getFood_ishot()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_isheavy().equals(data.getFood_isheavy()))
            {
                point += 1;
            }
            if(temp.get(i).getFood_isfried().equals(data.getFood_isfried()))
            {
                point += 1;
            }
            sumpoint.add(point);
        }
        for(int i =0; i < sumpoint.size(); i++)
        {
            if(sumpoint.get(i) == Collections.max(sumpoint))
            {
                recommend.add(temp.get(i));
            }
        }
        return  recommend;
    }
}
