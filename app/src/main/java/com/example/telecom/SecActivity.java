package com.example.telecom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

class SecActivity extends AppCompatActivity {
        @Override
            protected void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
                setContentView(R.layout.activity_sec);
                Button btn_send = findViewById(R.id.btn_send);
                TextView ed_name = findViewById(R.id.ed_name);
                TextView ed_phone = findViewById(R.id.ed_phone);

            btn_send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                   switch (v.getBottom())
                    {
                        case 0:
                            if(ed_name.length()<1)
                                showToast("請輸入姓名");

                            if (ed_phone.length()<1)
                                showToast("請輸入電話");
                            break;
                        default:
                            Bundle b = new Bundle();
                            Intent returnIntent = new Intent();
                            b.putString("name",ed_name.toString());
                            b.putString("phone",ed_name.toString());
                            setResult(Activity.RESULT_OK,
                                    returnIntent.putExtras(b));
                            finish();
                            break;
                    }
                }
            });
        }


            //建立 showToast 方法顯示 Toast 訊息
            private void showToast(String msg) {
                    Toast.makeText(this, msg,
                            Toast.LENGTH_SHORT).show();
                    }
}