package com.example.augustandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<MyListData> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.rvlist);
        listdata=new ArrayList<>();
        listdata.add(new MyListData("Apple","Macbook",R.mipmap.app_icon));
        listdata.add(new MyListData("Samsung","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("Xiaomi","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("OnePlus","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("Vivo","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("Realme","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("Oppo","Mobile",R.mipmap.app_icon));
        listdata.add(new MyListData("Nokia","Mobile",R.mipmap.app_icon));

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listdata);
        recyclerView.setHasFixedSize(true);
     //   recyclerView.setLayoutManager(new LinearLayoutManager(this));//vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}