package com.ulp.integrador06_sharedpreferences_gl.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ulp.integrador06_sharedpreferences_gl.R;
import com.ulp.integrador06_sharedpreferences_gl.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText etDNI, etLastName, etFirtsName, etMail, etPassw;
    private Button etRegister;

    private ViewModelRegister viewModelRegister;
    private String L = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        configView();

    }

    private void configView(){


        viewModelRegister = ViewModelProviders.of(this).get(ViewModelRegister.class);
        viewModelRegister.getUserList();
        etDNI = findViewById(R.id.etDni);
        etLastName = findViewById(R.id.etLastName);
        etFirtsName = findViewById(R.id.etFirstName);
        etMail = findViewById(R.id.etMail);
        etPassw = findViewById(R.id.etPassw);
        etRegister = findViewById(R.id.btRegistrarse);


        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etPassw == null && etMail == null && etLastName == null && etFirtsName == null &&etDNI == null){
                    User user = new User();
                    user.setDni(Long.parseLong(etDNI.getText().toString()));
                    user.setFirst_name(etFirtsName.getText().toString());
                    user.setLast_name(etLastName.getText().toString());
                    user.setMail(etMail.getText().toString());
                    user.setPassword(etPassw.getText().toString());
                    viewModelRegister.addUser(user);
                }
                else{

                    Toast.makeText(getApplication(),"Ingrese TODOS los DATOS",Toast.LENGTH_LONG).show();
                }

            }
        });


        Intent i=getIntent();


    L  = i.getStringExtra("L");
        if(L != null) {
    if (L.equals("L")) {
        User user = viewModelRegister.buscar();
        etDNI.setText(String.valueOf(user.getDni()));
        etFirtsName.setText(user.getFirst_name());
        etLastName.setText(user.getLast_name());
        etMail.setText(user.getMail());
        etPassw.setText(user.getPassword());
    }
}

    }
}
