package com.example.w2239.myapplication13;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.io.*;
import java.util.Map;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class LoginActivity extends AppCompatActivity implements OnClickListener{

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                Toast.makeText(LoginActivity.this,"登录失败再次登录",Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.login) {
            login();
        }
    }

    public void login(){        //登录函数
        new Thread(new Runnable() {
            @Override
            public void run() {
                EditText editTextUsername = (EditText) findViewById(R.id.usernameText);
                EditText editTextPassword = (EditText) findViewById(R.id.passwordText);
                String username = editTextUsername.getText().toString();      //获取学号
                String password = editTextPassword.getText().toString();      //获取密码

                try {
                    Connection connection = Jsoup.connect("http://zhjw.scu.edu.cn/j_spring_security_check");
                    connection.data("j_username", username, "j_password", password, "j_captcha1", "error");
                    Document doc = connection.post();
                    while (true) {                   //强制登录
                        if (doc.title().equals("URP综合教务系统首页")) {
                            Map cookies=connection.response().cookies();
                            Bundle bundle=new Bundle();
                            bundle.putSerializable("cookies",(Serializable)cookies);
                            bundle.putString("doc",doc.toString());
                            Intent intent = new Intent(LoginActivity.this, ChooseActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            break;
                        } else {
                            Message msg=Message.obtain();
                            msg.what=1;
                            handler.sendMessage(msg);
                            doc = connection.post();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
