package com.lxb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class singleInstanceMain extends BaseActivity implements OnClickListener {
	
	private Activity activity;
	private Button btn_standard;
	private Button btn_singleTop;
	private Button btn_singleTask;
	private Button btn_singleInstance;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        activity = this;
        
        findViews();
    }
    
    private void findViews() {
    	btn_standard = (Button) findViewById(R.id.btn_standard);
    	btn_singleTop = (Button) findViewById(R.id.btn_singleTop);
    	btn_singleTask = (Button) findViewById(R.id.btn_singleTask);
    	btn_singleInstance = (Button) findViewById(R.id.btn_singleInstance);
    	
    	btn_standard.setOnClickListener(this);
    	btn_singleTop.setOnClickListener(this);
    	btn_singleTask.setOnClickListener(this);
    	btn_singleInstance.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btn_standard:
			Intent standardIntent = new Intent(activity, A1.class);
			startActivity(standardIntent);
			break;
		case R.id.btn_singleTop:
			Intent singleTopIntent = new Intent(activity, B1.class);
			startActivity(singleTopIntent);
			break;
		case R.id.btn_singleTask:
			Intent singleTaskIntent = new Intent(activity, C1.class);
			startActivity(singleTaskIntent);
			break;
		case R.id.btn_singleInstance:
			Intent singleInstanceIntent = new Intent(activity, D1.class);
			startActivity(singleInstanceIntent);
			break;
		}
	}
    
}