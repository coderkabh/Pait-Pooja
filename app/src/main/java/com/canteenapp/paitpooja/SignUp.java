package com.canteenapp.paitpooja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.canteenapp.paitpooja.dashboard.DashboardFirstActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    TextInputLayout regName, regRollNumber, regEmail, regPhoneNumber, regPassword;
    Button regButton, regToLoginBtn;

    TextView regselected ;
    Spinner reggender;


    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        regName = findViewById(R.id.full_name);
        regRollNumber = findViewById(R.id.roll_number);
        regEmail = findViewById(R.id.e_mail);
        regPhoneNumber = findViewById(R.id.phone_number);
        regPassword = findViewById(R.id.password_box);
        regButton = findViewById(R.id.signup_btn);
        regToLoginBtn = findViewById(R.id.login_btn);

        regselected = findViewById(R.id.spinnerText);
        reggender = findViewById(R.id.spinnerGender);

        List<String> list = new ArrayList<String>();
        list.add( 0, "Select Gender");
        list.add("FEMALE");
        list.add("MALE");
        list.add("OTHERS");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.container_spinner,list);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reggender.setAdapter(arrayAdapter);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");
                if (!validateName() | !validateRollNumber() | !validateEmail() | !validatePhoneNumber() | !validatePassword()) {
                    return;
                }
                String name = regName.getEditText().getText().toString();
                String rollNumber = regRollNumber.getEditText().getText().toString();
                String eMail = regEmail.getEditText().getText().toString();
                String phoneNumber = regPhoneNumber.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();
/*
                String gender = reggender.getEditText().getText().toString();
*/
                User user = new User(name, rollNumber, eMail, phoneNumber, password);
                reference.child(rollNumber).setValue(user);
                Toast.makeText(SignUp.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DashboardFirstActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    private Boolean validatePhoneNumber() {
        String val4 = regPhoneNumber.getEditText().getText().toString();
        String mobileVal = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[6789]\\d{9}|(\\d[ -]?){10}\\d$";

        if (val4.isEmpty()) {
            regPhoneNumber.setError("Field cannot be empty");
            return false;
        }
        else if(!val4.matches(mobileVal)) {
            regPhoneNumber.setError("Wrong Phone Number");
            return false;
        }
        else {
            regPhoneNumber.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val5 = regPassword.getEditText().getText().toString();
        String passwordVal = "^" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$";

        if (val5.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        }
        else if(!val5.matches(passwordVal)) {
            regPassword.setError("Password is too weak ");
            return false;
        }
        else {
            regPassword.setError(null);
            return true;
        }

    }

    public void loginUser(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}