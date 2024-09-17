package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etConfSenha;
    private Button btnRegistrar;
    private TextView tvLogin;

    public static String usuarioX, emailX, senhax, confSenhaX;
    String host = "https://LinkDoBanco/exemplo";
    String url;
    String ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializar os elementos da UI
        etUsuario = findViewById(R.id.etUsuario);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etConfSenha = findViewById(R.id.etConfSenha);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvLogin = findViewById(R.id.tvLogin);

        // Configurar o botão de registro
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsuario.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() ||
                        etSenha.getText().toString().isEmpty() || etConfSenha.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Preencha todos os campos!", Snackbar.LENGTH_SHORT).show();

                } else if (etSenha.getText().toString().equals(etConfSenha.getText().toString())) {
                    // Chamando método
                    LidarComRegistrar();

                } else {
                    Snackbar.make(v, "As senhas não correspondem, por favor escreva-as novamente",
                            Snackbar.LENGTH_SHORT).show();
                }
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
        url = host + "inserirAluno.php";
        Ion.with(CadastroActivity.this)
                .load(url)
                .setBodyParameter("usuario", etUsuario.getText().toString())
                .setBodyParameter("email", etEmail.getText().toString())
                .setBodyParameter("senha", etSenha.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if (ret.equals("ok")) {
                            Toast.makeText(getApplicationContext(),
                                    "Cadastro realizado com sucesso!",
                                    Toast.LENGTH_LONG).show();

                            Intent CApL = new Intent(CadastroActivity.this, LoginActivity.class);
                            CadastroActivity.this.startActivity(CApL);

                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "ERRO!!!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private boolean EmailValido(String etEmail) {
        // Regex para validação básica de email
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(emailPattern, etEmail);
    }

    private void NavegarPraLogin() {
        // Navegar para a tela de login
        Intent Logar = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(Logar);
    }
}
