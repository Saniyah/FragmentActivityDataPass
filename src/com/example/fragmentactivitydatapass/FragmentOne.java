package com.example.fragmentactivitydatapass;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOne extends Fragment {
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      
	  View view = inflater.inflate(R.layout.fragment_one, container, false);

             
      TextView tv1 = (TextView) view.findViewById(R.id.textView1);	    
	  Bundle bundle1 = this.getArguments();
	  if (bundle1 != null) {
		  String getArgument = bundle1.getString("data");
	      tv1.setText(getArgument);
	     }
     
     Bundle bundle2 = new Bundle();
	 bundle2.putString("fData","Data from Fragment");

	 Intent intent = getActivity().getIntent();
	 intent.putExtras(bundle2);
    
	    return view;
   }
}
