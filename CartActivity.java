package com.example.makeupapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupapp.Adapter.CartListAdapter;
import com.example.makeupapp.Helper.ManagementCart;
import com.example.makeupapp.Interface.ChangeNumberItemListener;

public class CartActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerViewList;
private ManagementCart managementCart;
private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
private double tax;
private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart=new ManagementCart(this);
        initView();
        initList();
        bottomNavigation();
    }
    private void bottomNavigation() {
        LinearLayout HomeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.homeBtn);
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,Profile.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,CartActivity.class));
            }
        });
    }
    private void initList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
   recyclerViewList.setLayoutManager(linearLayoutManager);
    adapter=new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemListener() {
        @Override
        public void changed() {
           calculateCard();
        }
    });
    recyclerViewList.setAdapter(adapter);
    if (managementCart.getListCart().isEmpty()){
        emptyTxt.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
      }else{
        emptyTxt.setVisibility(View.GONE);
        scrollView.setVisibility(View.VISIBLE);
      }
    }

    private void calculateCard() {
        double percentaTax=0.02;//you can change this item for tax price
        double delivery=10;//you can change this item you need price for delivery

        tax=Math.round((managementCart.getTotalFee()*percentaTax)*100.0)/100.0;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal=Math.round(managementCart.getTotalFee()*100.0)/100.0;

        totalFeeTxt.setText("$"+itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }

    private void initView() {
    totalFeeTxt=findViewById(R.id.totalFeeTxt);
    taxTxt=findViewById(R.id.taxTxt);
    deliveryTxt=findViewById(R.id.deliveryTxt);
    totalTxt=findViewById(R.id.totalTxt);
    recyclerViewList=findViewById(R.id.view);
    scrollView=findViewById(R.id.scrollView);
    emptyTxt=findViewById(R.id.emptyTxt);
    }
}