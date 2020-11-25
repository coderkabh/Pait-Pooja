package com.canteenapp.paitpooja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    }
}