package com.ulp.integrador06_sharedpreferences_gl.ui.register;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.integrador06_sharedpreferences_gl.User;
import com.ulp.integrador06_sharedpreferences_gl.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class ViewModelRegister extends AndroidViewModel {

    private  MutableLiveData<List<User>> userListLiveData;
    private Context context;
    public ViewModelRegister(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<List<User>> getUserList(){
        if(userListLiveData == null){
            userListLiveData = new MutableLiveData<List<User>>();
        }
        return userListLiveData;
    }

    public void addUser(User user){
        ApiClient.guardar(context,user);
    }

    public User buscar(){
        User user = ApiClient.leer(context);
        return user;
    }

}
