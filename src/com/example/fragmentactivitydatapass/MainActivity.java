package com.example.fragmentactivitydatapass;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class MainActivity extends Activity {
	EditText edTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      
      edTxt = (EditText)findViewById(R.id.editText1);
      Button button1 = (Button)findViewById(R.id.button1);
		
	  button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Fragment fr = new FragmentOne();
				Bundle bundle1 = new Bundle();
				bundle1.putString("data",edTxt.getText().toString());
				fr.setArguments(bundle1);
				FragmentManager fm = getFragmentManager();
		        FragmentTransaction fragmentTransaction = fm.beginTransaction();
		        fragmentTransaction.replace(R.id.fragment_place,fr);
		        fragmentTransaction.commit();
		        edTxt.setText("");
		        
				Toast.makeText(getApplicationContext(),"Data Passed ... !!",2000).show();
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
	    button2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					 Bundle bundle2 = getIntent().getExtras();
				      if (bundle2 != null)
				      {  
				          String data = bundle2.getString("fData");
				          edTxt.setText(data);
				      }
				}
			});

	}
}
