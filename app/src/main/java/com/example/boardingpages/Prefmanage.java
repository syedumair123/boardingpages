package com.example.boardingpages;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefmanage {
    Context context;
    SharedPreferences sharedPreferences;
    public Prefmanage(Context context){
this.context=context;
initializesharedpref();
    }
    public void initializesharedpref(){

        sharedPreferences=context.getSharedPreferences(context.getString(R.string.my_pref),Context.MODE_PRIVATE);
    }
    public void wriesharedpref(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_pref_key),"init");
        editor.commit();
    }
    public boolean chkpref(){
        boolean status=false;
        if(sharedPreferences.getString(context.getString(R.string.my_pref_key),null).equals("null")){
            status=false;

        }
        else {
            status=true;
        }
        return status;
    }
    public void clearpref(){
        sharedPreferences.edit().clear().commit();

    }
}
