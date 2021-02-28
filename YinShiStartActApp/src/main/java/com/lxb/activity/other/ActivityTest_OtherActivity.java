package com.lxb.activity.other;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTest_OtherActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText("taskId: " + getTaskId());
        
        Button btn_testSingleTask = (Button) findViewById(R.id.btn_testSingleTask);
        btn_testSingleTask.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.lxb.activity.singletask");
				startActivity(intent);
			}
		});
        Button btn_testSingleInstance = (Button) findViewById(R.id.btn_testSingleInstance);
        btn_testSingleInstance.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.lxb.activity.singleinstance");
				startActivity(intent);
			}
		});
        
    }
}