package com.example.akshatsharma.akshatcountertask;

import android.app.Application;

/**
 * Created by akshatsharma on 3/30/15.
 */
public class CounterApplication extends Application {

    public int seconds=0;
    private static CounterApplication singleton;
    static CounterThread ob;


    public static CounterApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        seconds=1;
        singleton=this;


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //seconds=1;
    }

    public static void ThreadExecute(){
        ob=new CounterThread();
        ob.execute();
    }

    public static void ThreadInterrupt(){
        ob.cancel(true);
    }

}
