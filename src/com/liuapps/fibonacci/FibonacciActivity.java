package com.liuapps.fibonacci;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FibonacciActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private final String TAG = FibonacciActivity.class.getSimpleName();
	TextView resultsView;
	Button button;
	EditText inputText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        resultsView = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.buttonSubmit);
        inputText = (EditText) findViewById(R.id.editText1);
        button.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		long input;
		try {
			input = Long.parseLong(inputText.getText().toString());
		} catch (NumberFormatException e) {
			Log.d(TAG, "Error parsing string");
			resultsView.setText("Please input valid number.");
			return;
		}
		resultsView.setText("Calculating...");
		new CalculateFibonacci().execute(input);
	}
	
	private class CalculateFibonacci extends AsyncTask<Long, Integer, String> {

		@Override
		protected String doInBackground(Long... inputs) {
			long input = inputs[0];
			long result, start, stop;
			String out = new String();

			start = System.currentTimeMillis();
			result = FibLib.fibJ(input);
			stop = System.currentTimeMillis();
			out += String.format("Java Recursive [%d] took: %d ms\n", result, stop-start);
			
			start = System.currentTimeMillis();
			result = FibLib.fibJI(input);
			stop = System.currentTimeMillis();
			out += String.format("Java Iterative [%d] took: %d ms\n", result, stop-start);

			start = System.currentTimeMillis();
			result = FibLib.fibN(input);
			stop = System.currentTimeMillis();
			out += String.format("Native Recursive [%d] took: %d ms\n", result, stop-start);

			start = System.currentTimeMillis();
			result = FibLib.fibNI(input);
			stop = System.currentTimeMillis();
			out += String.format("Native Iterative [%d] took: %d ms", result, stop-start);

			return out;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			resultsView.setText(result);
		}
		
	}
}