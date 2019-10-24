package com.ulp.integrador06_sharedpreferences_gl.ui.loggin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.ulp.integrador06_sharedpreferences_gl.User;
import com.ulp.integrador06_sharedpreferences_gl.request.ApiClient;
import com.ulp.integrador06_sharedpreferences_gl.ui.register.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class ViewModelLoggin extends AndroidViewModel {

    private  MutableLiveData<User> userListLiveData;
    private Context context;

    public ViewModelLoggin(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<User> getUserList(){

        if(userListLiveData == null){
            userListLiveData = new MutableLiveData<User>();

        }
        return userListLiveData;
    }

    public void buscar(String mail, String passw){
        User user = ApiClient.Login(context,mail,passw);

        if(user != null ){
           getUserList();
           userListLiveData.setValue(user);

            Intent i = new Intent(context,RegisterActivity.class);
            i.putExtra("L","L");
            context.startActivity(i);
        }
        else {
            Toast.makeText(context,"Usuario no valido",Toast.LENGTH_LONG).show();
        }
    }



}
