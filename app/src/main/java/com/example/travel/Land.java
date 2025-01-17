package com.example.travel;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Land extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land);
        if(Build.VERSION.SDK_INT>=21){
        View decorView=getWindow().getDecorView();
        int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameinput = (EditText) findViewById(R.id.edittext1);
                EditText psinput = (EditText) findViewById(R.id.edittext2);
                String name = nameinput.getText().toString();
                String ps = psinput.getText().toString();
                if (name.equals("admin") && ps.equals("123456")) {
                    Intent intent = new Intent(Land.this, Main.class);
                    Toast.makeText(Land.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else Toast.makeText(Land.this, "您的账号或密码有误，请重新输入", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageView=(ImageView) findViewById(R.id.false_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      /* psinput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (psinput.getText().length()>0) {
                    imageView1.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                }
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psinput.setText("");
            }
        });
      /* psinput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean arg1) {
                if(psinput.getText().length()==0) {
                    imageView1.setVisibility(View.INVISIBLE);
                }else {
                    imageView1.setVisibility(View.VISIBLE);
            }
        if(arg1) {
           } else {
               //失去焦点，删除图标隐藏
               imageView1.setVisibility(View.VISIBLE);


    }
    }});
    */
    }
}