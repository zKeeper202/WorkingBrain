package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etEmail;
    private EditText etSenha;
    private Button btnRegistrar;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializar os elementos da UI
        etUsuario = findViewById(R.id.etUsuario);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvLogin = findViewById(R.id.tvLogin);

        // Configurar o botão de registro
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LidarComRegistrar();
            }
        });

        // Configurar o texto para navegação ao login
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavegarPraLogin();
            }
        });
    }

    private void LidarComRegistrar() {
        String username = etUsuario.getText().toString();
        String email = etEmail.getText().toString();
        String password = etSenha.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!!", Toast.LENGTH_SHORT).show();
        } else if (!EmailValido(email)) {
            Toast.makeText(this, "Formato de e-mail inválido!", Toast.LENGTH_SHORT).show();
        } else {
            // Exemplo simples de sucesso
            Toast.makeText(this, "Registrado com sucesso!", Toast.LENGTH_SHORT).show();
            // adicionar lógica para armazenar os dados do usuário
            // e possivelmente iniciar outra atividade ou retornar à tela de login.
        }
    }

    private boolean EmailValido(String email) {
        // Regex para validação básica de email
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(emailPattern, email);
    }

    private void NavegarPraLogin() {
        // Navegar para a tela de login
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
