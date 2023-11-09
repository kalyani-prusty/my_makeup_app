package com.example.makeupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.makeupapp.Domain.Makeupdomain;
import com.example.makeupapp.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity
{
private TextView addToCartBtn,titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
private TextView totalPriceTxt,starTxt,caloryTxt,timeTxt;
private ImageView plusBtn,minusBtn,picMakeup;
private Makeupdomain object;
private int numberOrder=1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart=new ManagementCart(this);
        iniView();
        getBundle();
    }

    private void getBundle() {
        object=(Makeupdomain)getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picMakeup);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        //caloryTxt.setText(object.getCalories()+"calories");
        starTxt.setText(object.getStar()+"");
        timeTxt.setText(object.getTime()+"minutes");
        totalPriceTxt.setText("$"+(numberOrder*object.getFee()));

        plusBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+(numberOrder*object.getFee()));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (numberOrder > 1){
                    numberOrder=numberOrder-1;
                }
                    numberOrderTxt.setText(String.valueOf(numberOrder));
                    totalPriceTxt.setText("$"+(numberOrder*object.getFee()));
                }
            });
        addToCartBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertMakeup(object);
            }
        });
    }

    private void iniView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        addToCartBtn=findViewById(R.id.addToCartBtn);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        totalPriceTxt=findViewById(R.id.totalPriceTxt);
        starTxt=findViewById(R.id.starTxt);
        timeTxt=findViewById(R.id.timeTxt);
        caloryTxt=findViewById(R.id.caloryTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        picMakeup=findViewById(R.id.makeupPic);
    }
}