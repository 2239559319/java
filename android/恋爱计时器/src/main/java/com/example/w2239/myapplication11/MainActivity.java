package com.example.w2239.myapplication11;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import android.graphics.Typeface;
import 	android.support.v4.content.res.ResourcesCompat;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Handler handler;
    private long startDate=1541345424;

    public String getString(){
        Date curDate=new Date();
        long curSecond=curDate.getTime()/1000;
        long totalSeconds=curSecond-this.startDate;

        long []timeLen={365*24*60*60,24*60*60,60*60,60};
        long year=totalSeconds/timeLen[0];
        long day=(totalSeconds-year*timeLen[0])/timeLen[1];
        long hour=(totalSeconds-year*timeLen[0]-day*timeLen[1])/timeLen[2];
        long minute=(totalSeconds-year*timeLen[0]-day*timeLen[1]-hour*timeLen[2])/timeLen[3];
        long second=totalSeconds-year*timeLen[0]-day*timeLen[1]-hour*timeLen[2]-minute*timeLen[3];

        return "张懿 万川琳\n"+"相恋"+year+"年"+day+"天"+hour+"小时"+minute+"分"+second+"秒";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        Typeface typeface = ResourcesCompat.getFont(this,R.font.w1);
        textView.setTypeface(typeface);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                textView.setText(getString());
            }
        };
        Threads thread = new Threads();
        thread.start();
    }
    class Threads extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String str="秒";
                    handler.sendMessage(handler.obtainMessage(100, str));
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
