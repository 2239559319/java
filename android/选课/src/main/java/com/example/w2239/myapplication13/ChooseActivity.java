package com.example.w2239.myapplication13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.nodes.*;
import org.jsoup.*;

import java.util.*;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener{
    private Map cookies;
    private String fajhh="3623";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        setWelcome();
        //点击选课处理
        Button choose=(Button)findViewById(R.id.choose);
        choose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.choose){
            choose();
        }
    }

    public void choose(){           //判断选课的门数，多线程

    }

    public void chooseOneCourse(String courseNum,String courseId){      //选一门课

    }

    public void setWelcome(){
        //获取登录数据
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        this.cookies=(Map)bundle.getSerializable("cookise");
        String val=bundle.getString("doc");          //doc.toString();
        Document doc=Jsoup.parse(val);
        String userinfo = doc.getElementsByClass("user-info").toString();
        Document name=Jsoup.parse(userinfo);
        //欢迎界面
        TextView textViewWelcome=(TextView)findViewById(R.id.textWelcome);
        textViewWelcome.setText(name.text());
    }
}
