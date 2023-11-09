package com.example.makeupapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.makeupapp.Adapter.CategoryAdapter;
import com.example.makeupapp.Adapter.RecommendedAdapter;
import com.example.makeupapp.Domain.CategoryDomain;
import com.example.makeupapp.Domain.Makeupdomain;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    private RecyclerView.Adapter adapter2;
private RecyclerView recyclerViewCategotyList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout HomeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.homeBtn);
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,Profile.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

ArrayList<Makeupdomain>productlist=new ArrayList<>();
        productlist.add(new Makeupdomain("Lipstic","pic_1","good",100,5,25));
        productlist.add(new Makeupdomain("eyeliner","pic_2","better",150,4,15));
        productlist.add(new Makeupdomain("foundation","pic_3","excellent",200,5,20));
    adapter2=new RecommendedAdapter(productlist);
    recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategotyList = findViewById(R.id.recyclerView);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("lipstic","pic_1"));
        categoryList.add(new CategoryDomain("eyeliner","pic_2"));
        categoryList.add(new CategoryDomain("foundation","pic_3"));
        categoryList.add(new CategoryDomain("mascara","pic_4"));
        categoryList.add(new CategoryDomain("eyebrow pencil","pic_5"));

        RecyclerView.Adapter adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }

}