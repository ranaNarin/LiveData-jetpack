package com.service.demo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG=this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber(){
        Log.e(TAG, "Get Number");

        if(myRandomNumber==null){
            myRandomNumber=new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber(){
        Log.e(TAG, "Create new number");
        Random random=new Random();
        myRandomNumber.setValue("Number: "+(random.nextInt(10-1)+1));

    }

}
