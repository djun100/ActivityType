package com.lxb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseActivity extends Activity {
    private String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = "trace-- "+getClass().getSimpleName();
        Log.i(tag,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"onResume");
//        exec("");
        //adb shell dumpsys activity activities
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(tag,"onNewIntent");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"onDestroy");
    }

    private static String exec(String command) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
        //这里一定要注意错误流的读取，不然很容易阻塞，得不到你想要的结果，
        final BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        new Thread(new Runnable() {
            String line;
            public void run() {
                String[] info;
                try {
                    while ((line = inputStream.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        int i = 0;
        try {
            i = process.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("i=" + i);
        return null;
    }
}
