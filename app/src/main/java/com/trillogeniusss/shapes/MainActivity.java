package com.trillogeniusss.shapes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onclick(View view){
	EditText userInput = (EditText)findViewById(R.id.input);
	if(userInput.getText().toString().isEmpty()){
	    Toast.makeText(getApplicationContext(),"Please Enter a Number", Toast.LENGTH_LONG).show();
	}else {
	    double uNumb = Double.parseDouble(userInput.getText().toString());
	    Number var = new Number(uNumb);
	    if (var.isTriangle() && !var.isSquare()) {
		System.out.println(var.number + " is a Triangle Number");
		Toast.makeText(getApplicationContext(), var.number + " is a Triangle Number", Toast.LENGTH_LONG).show();
	    } else if (!var.isTriangle() && var.isSquare()) {
		System.out.println(var.number + " is a Square Number");
		Toast.makeText(getApplicationContext(), (int) var.number + " is a Square Number", Toast.LENGTH_LONG).show();
	    } else if (var.isTriangle() && var.isSquare()) {
		System.out.println(var.number + " is both a Triangle Number and a Square Number");
		Toast.makeText(getApplicationContext(), (int) var.number + " is both a Triangle Number and a Square Number", Toast.LENGTH_LONG).show();
	    } else {
		System.out.println(var.number + " is None");
		Toast.makeText(getApplicationContext(), (int) var.number + " is None", Toast.LENGTH_LONG).show();
	    }
	}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	setSupportActionBar(toolbar);

	FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
	fab.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View view) {
		Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
		    .setAction("Action", null).show();
	    }
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	//noinspection SimplifiableIfStatement
	if (id == R.id.action_settings) {
	    return true;
	}

	return super.onOptionsItemSelected(item);
    }
}

class Number{
    double number;
    public Number(double num){
	number = num;
    }

    public boolean isTriangle(){
	boolean isTri = false;
	double temp = number;
	int subtractror = 1;
	while (temp > 0 ){
	    temp = temp - subtractror;
	    subtractror++;
	}
	if(temp == 0){
	    isTri = true;
	}
	return isTri;
    }

    public boolean isSquare(){
	boolean isSqr = false;
	double root = Math.sqrt(number);
	if(root%1==0){
	    isSqr = true;
	}
	return isSqr;
    }
}
