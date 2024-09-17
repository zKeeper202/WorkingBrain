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

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRecuperar;
    private TextView tvRegistrar;
    public static String usuariox, senhax;
    String host="https://LinkDoBanco/exemplo";

    String url;
    String ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar os elementos da UI
        etUsername = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        tvRegistrar = findViewById(R.id.tvRegistrar);

        // Configurar o botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { LidarcomLogin();}
        });

        // Configurar o texto para navegação ao cadastro
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavegarpraRegistrar();
            }
        });
    }

    private void LidarcomLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            // Exemplo simples de sucesso
            Toast.makeText(this, "Login realizado", Toast.LENGTH_SHORT).show();
        }
    }

    private void NavegarpraRegistrar() {
        Intent NpC = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(NpC);
    }
}
