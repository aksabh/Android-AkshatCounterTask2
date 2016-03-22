package com.example.akshatsharma.akshatcountertask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends ActionBarActivity {

    static TextView myText;
    Button b1;
    private static int count;
    public static final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "AOP_PREFS_String";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.button);


        CounterApplication.ThreadExecute();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings;
                Context context=getApplicationContext();
                SharedPreferences.Editor editor;
                settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
                editor = settings.edit(); //2

                editor.putInt(PREFS_KEY, (CounterApplication.getInstance().seconds)=0); //3
                editor.commit(); //4
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings;
        Context context=getApplicationContext();
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putInt(PREFS_KEY, (CounterApplication.getInstance().seconds)); //3
        editor.commit(); //4
        CounterApplication.ThreadInterrupt();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences  settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        (CounterApplication.getInstance().seconds)=settings.getInt(PREFS_KEY,0);
        CounterApplication.ThreadExecute();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /*SharedPreferences  settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        (CounterApplication.getInstance().seconds)=settings.getInt(PREFS_KEY,0);
        CounterApplication.ThreadExecute();
    */
        (CounterApplication.getInstance().seconds)=1;
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings;
        //(CounterApplication.getInstance().seconds)=1;
        Context context=getApplicationContext();
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putInt(PREFS_KEY, (CounterApplication.getInstance().seconds)); //3
        editor.commit(); //4
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences  settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        (CounterApplication.getInstance().seconds)=settings.getInt(PREFS_KEY,0);
        CounterApplication.ThreadExecute();
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
