package com.example.telecom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //將變數與 XML 元件綁定
        RecyclerView recycleView = findViewById(R.id.recyclerView);
        Button btn_add = findViewById(R.id.btn_add);

        //創建 LinearLayoutManager 物件，設定垂直排列
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, true);
        recycleView.setLayoutManager(LayoutManager);

        //創建 MyAdapter 並連結 recyclerView
        MyAdapter adapter = new MyAdapter(contacts);
        recycleView.setAdapter(adapter);

        //設定按鈕監聽器，使用 startActivityForResult()啟動 SecActivity
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
            @Override//接收回傳資料
              protected void onActivityResult(int requestCode, int resultCode,
                                              @Nullable Intent data){
                    super.onActivityResult(requestCode, resultCode, data);
                    if(data == null) return;

                        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                            Bundle b = data.getExtras();
                            contacts.add(new Contact(b.getString("name",""),
                                    b.getString("phone","")));
                            adapter.notifyDataSetChanged();
                        }
                    }
class Contact {
    String name; //姓名
    int phone;//電話

        public Contact(String name, String phone) { }

    }
}