package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar os elementos da UI
        etUsername = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegistrar = findViewById(R.id.tvRegister);

        // Configurar o botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        // Configurar o texto para navegação ao cadastro
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister();
            }
        });
    }

    private void handleLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            // Exemplo simples de sucesso
            Toast.makeText(this, "Login realizado", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);
    }
}
