package com.example.marchandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    EditText edtMobileNo,edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtMobileNo=findViewById(R.id.edtphone);
        edtPassword=findViewById(R.id.edtpassword);
        btnLogin=findViewById(R.id.btnlogin);

        SharedPreferences sharedPreferences=getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobileNo=edtMobileNo.getText().toString();
                String password=edtPassword.getText().toString();

                if(mobileNo.equals("9876543210") && password.equals("123456")){
                  Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                  editor.putString("islogin","true");
                  editor.commit();
                    Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }
                else if (mobileNo.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Enter Mobile No.", Toast.LENGTH_SHORT).show();
                }
                else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}