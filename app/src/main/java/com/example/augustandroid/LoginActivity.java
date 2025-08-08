package com.example.augustandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtPhone;
    EditText edtPassword;
    Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtPhone=findViewById(R.id.edtphone);
        edtPassword=findViewById(R.id.edtpassword);
        btnLogin=findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId=edtPhone.getText().toString();
                String password=edtPassword.getText().toString();
                if (userId.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else if (userId.equals("9876543210") && password.equals("123456"))
                {
                    Intent intent=new Intent(getApplicationContext(),ActivityLifecycle.class);
                    startActivity(intent);
                    Log.e("Login","Login Success");
                }else {
                    Log.e("Login","Login Failed");
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(LoginActivity.this, "Login Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}