package com.lxb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class singleTopB2 extends BaseActivity {
	
	TextView tv_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_layout);
		
		tv_text = (TextView) findViewById(R.id.tv_text);
		tv_text.setText(this.toString());
		
		Button btn_goB1 = (Button) findViewById(R.id.btn_goB1);
		btn_goB1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(singleTopB2.this, B1.class);
				startActivity(intent);
			}
		});
		Button btn_goB2 = (Button) findViewById(R.id.btn_goB2);
		btn_goB2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(singleTopB2.this, singleTopB2.class);
				startActivity(intent);
			}
		});

		Button btn_goSingleInstanceD2 = (Button) findViewById(R.id.btn_goSingleInstanceD2);
		btn_goSingleInstanceD2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(singleTopB2.this, singleInstanceD2.class);
				startActivity(intent);
			}
		});

	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		
		tv_text.setText(this.toString() + "\n" + "onNewIntent() called");
	}

}
