package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Data> recommend = (ArrayList<Data>) intent.getSerializableExtra("recommend_food");
        for(int i = 0; i < recommend.size(); i++)
        {
            name.add(recommend.get(i).getFood_name());
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.widget_item, name);

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(myListAdapter);
    }

}

class MyListAdapter extends BaseAdapter {
    Context maincon;
    LayoutInflater inflater;
    ArrayList<String> arSrc;
    int layout;

    public MyListAdapter(Context context, int alayout, ArrayList<String> aarSrc)
    {
        maincon = context;
        layout = alayout;
        arSrc = aarSrc;
        inflater = LayoutInflater.from(maincon);
    }

    public int getCount()
    {
        return arSrc.size();
    }
    public Object getItem(int position) {
        return arSrc.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        final  int pos = position;
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        TextView txt = (TextView)convertView.findViewById(R.id.textView3);
        txt.setText(arSrc.get(position));

        Button btn = (Button)convertView.findViewById(R.id.button2);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = arSrc.get(pos);
                String url = "nmap://search?query=" + str + "&appname=com.example.myapplication";
                //Intent intent = new Intent(maincon, NaverMap.class);
                //maincon.startActivity(intent);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                maincon.startActivity(intent);
            }
        });
        return convertView;
    }
}
