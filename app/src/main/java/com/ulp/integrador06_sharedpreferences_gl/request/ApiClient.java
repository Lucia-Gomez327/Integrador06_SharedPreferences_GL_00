package com.ulp.integrador06_sharedpreferences_gl.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.ulp.integrador06_sharedpreferences_gl.User;

public class ApiClient {

    private static SharedPreferences sp;

    private static  SharedPreferences conectar (Context context){
       if(sp == null){
        sp = context.getSharedPreferences("datos",0);
    }
    return sp;
    }

    public static void guardar (Context context, User user){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni",user.getDni());
        editor.putString("last_name",user.getLast_name());
        editor.putString("first_name",user.getLast_name());
        editor.putString("mail",user.getMail());
        editor.putString("password", user.getPassword());
        editor.commit();
    }

    public static User leer (Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni",-1);
        String last_name= sp.getString("last_name","-1");
        String first_name=sp.getString("first_name","-1");
        String mail=sp.getString("mail","-1");
        String password=sp.getString("password","-1");
        User usuario= new User(dni,last_name,first_name,mail,password);

        return usuario;
    }

public static User Login(Context context, String mail, String password){
    User usuario=null;
    SharedPreferences sp= conectar(context);
    Long dni = sp.getLong("dni",-1);
    String last_name= sp.getString("last_name","-1");
    String first_name=sp.getString("first_name","-1");
    String email=sp.getString("mail","-1");
    String passw=sp.getString("password","-1");

    Log.d("salida", last_name);
    if(mail.equals(email)&&password.equals(passw)){
        usuario= new User(dni,last_name,first_name,mail,password);

    }
    return usuario;

}
}
