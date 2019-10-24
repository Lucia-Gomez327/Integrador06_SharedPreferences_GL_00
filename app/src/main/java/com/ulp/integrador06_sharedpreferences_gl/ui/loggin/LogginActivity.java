package com.ulp.integrador06_sharedpreferences_gl.ui.loggin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ulp.integrador06_sharedpreferences_gl.R;
import com.ulp.integrador06_sharedpreferences_gl.User;
import com.ulp.integrador06_sharedpreferences_gl.ui.register.RegisterActivity;
import com.ulp.integrador06_sharedpreferences_gl.ui.register.ViewModelRegister;

public class LogginActivity extends AppCompatActivity {

    private EditText etEmail, etPassw;
    private Button btLoggin, btRegister;
    private ViewModelRegister viewModelRegister;
    private ViewModelLoggin viewModelLoggin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        configView();
    }



    public void configView(){
       etEmail = findViewById(R.id.etEmail1);
       etPassw = findViewById(R.id.etPassw1);
       btLoggin = findViewById(R.id.btIniciar);
       btRegister = findViewById(R.id.btRegistrate);

       btRegister.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
           }
             });
        viewModelRegister = ViewModelProviders.of(this).get(ViewModelRegister.class);
       viewModelRegister.getUserList();
        viewModelLoggin = new ViewModelLoggin(getApplication());

       btLoggin.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               if(etPassw == null || etEmail == null){
                   Toast.makeText(getApplication(),"Ingrese datos",Toast.LENGTH_LONG).show();
               }
               else {
                   viewModelLoggin.buscar(etEmail.getText().toString(), etPassw.getText().toString());
               }

           }
       });


   }
}
