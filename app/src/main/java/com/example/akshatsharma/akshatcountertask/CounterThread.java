package com.example.akshatsharma.akshatcountertask;

import android.os.AsyncTask;

/**
 * Created by akshatsharma on 3/30/15.
 */
public class CounterThread extends AsyncTask<Integer,Integer,Integer> {

    //public int count=0;
    //MainActivity mainActivity;

    CounterApplication obj3;


//initialization will take a little time you if you want to send message check if handler  != null


    @Override
    protected void onPreExecute() {

           obj3=new CounterApplication();

    }

    @Override
    protected Integer doInBackground(Integer... params) {

        try {


            Thread.sleep(1000);
            (CounterApplication.getInstance().seconds)=(CounterApplication.getInstance().seconds)+1;


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {

        MainActivity.myText.setText((CounterApplication.getInstance().seconds)+"");
        CounterApplication.ThreadExecute();


    }
}