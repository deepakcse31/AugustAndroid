package com.example.augustandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {

    EditText edtFirstNo;
    EditText edtSecondNo;
    Button btnAdd;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);
        edtFirstNo=findViewById(R.id.edtfirstNo);
        edtSecondNo=findViewById(R.id.edtsecondNo);
        btnAdd=findViewById(R.id.btnadd);
        tvResult=findViewById(R.id.tvresult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("Result :-"+add(edtFirstNo.getText().toString(),edtSecondNo.getText().toString()));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private String add(String firstNo,String secondNo){
        int num1=Integer.parseInt(firstNo);
        int num2=Integer.parseInt(secondNo);
        int sum=num1+num2;
        return String.valueOf(sum);
    }
}