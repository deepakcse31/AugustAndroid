package com.example.augustandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.augustandroid.databinding.ActivityPhoneBinding;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneActivity extends AppCompatActivity {

    ActivityPhoneBinding binding;
    ApiService apiService;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService=ApiClient.getClient().create(ApiService.class);

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterPhoneNo=binding.edtphoneno.getText().toString();
                createUser(enterPhoneNo);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void createUser(String phoneNo){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("phone_number",phoneNo);
        Call<ResponseModel> call=apiService.createUser(jsonObject);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()){
                    Log.e("API_SUCCESS",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }
}