package com.example.androidlabtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

TextInputLayout emailTextField,passwordTextField,securityTextField;
Button registerButton,clearButton,displayButton,overwriteButton;
Switch aSwitch;
    SharedPreferences sharedPreference;
    boolean isSwitchON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreference =  this.getPreferences( Context.MODE_PRIVATE );
        isSwitchON = false;
        emailTextField = findViewById(R.id.email_textfield);
        passwordTextField = findViewById(R.id.password_textfield);
        securityTextField = findViewById(R.id.security_textfield);
        registerButton = findViewById(R.id.register_button);
        clearButton = findViewById(R.id.clear_button);
        displayButton = findViewById(R.id.display_button);
        overwriteButton = findViewById(R.id.overwrite_button);
        aSwitch = findViewById(R.id.switch1);


        aSwitch.setChecked(isSwitchON);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isSwitchON = b;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailTextField.getEditText().getText().clear();
                passwordTextField.getEditText().getText().clear();
                securityTextField.getEditText().getText().clear();

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( emailTextField.getEditText().getText().length()<=0 || passwordTextField.getEditText().getText().length()<=0||securityTextField.getEditText().getText().length()<=0){
                    Toast.makeText(MainActivity.this, "Enter Data in Fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(isSwitchON){
 Toast.makeText(MainActivity.this, "SQL", Toast.LENGTH_SHORT).show();
                    }else{
                        //SHARTED PREF
                        SharedPreferences.Editor editor = sharedPreference.edit();
                        editor.putString("email",emailTextField.getEditText().getText().toString());
                        editor.putString("password",passwordTextField.getEditText().getText().toString());
                        editor.putString("security",securityTextField.getEditText().getText().toString());
                        editor.apply();
                        Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSwitchON){
// SQL
                }else{
                    //SHARTED PREF
                    emailTextField.getEditText().setText(sharedPreference.getString("email","EMPTY"));
                    passwordTextField.getEditText().setText(sharedPreference.getString("password","EMPTY"));
                    securityTextField.getEditText().setText(sharedPreference.getString("security","EMPTY"));
                    Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();

                }
            }
        });
        overwriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( emailTextField.getEditText().getText().length()<=0 || passwordTextField.getEditText().getText().length()<=0||securityTextField.getEditText().getText().length()<=0){
                    Toast.makeText(MainActivity.this, "Enter Data in Fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(isSwitchON){
// SQL
                    }else{
                        //SHARTED PREF
                        SharedPreferences.Editor editor = sharedPreference.edit();
                        editor.putString("email",emailTextField.getEditText().getText().toString());
                        editor.putString("password",passwordTextField.getEditText().getText().toString());
                        editor.putString("security",securityTextField.getEditText().getText().toString());
                        editor.apply();
                        Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}