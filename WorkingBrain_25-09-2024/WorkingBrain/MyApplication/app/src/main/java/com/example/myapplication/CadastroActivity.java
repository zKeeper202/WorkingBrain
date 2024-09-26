package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private EditText etUsuario, etEmail, etSenha, etConfSenha;
    private Button btnRegistrar;
    private TextView tvLogin;
    String host = "http://zkeeper202.serv00.net/projeto/";
    String url;
    String ret;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializar os elementos da UI
        etUsuario = findViewById(R.id.etUsuario);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        //etConfSenha = findViewById(R.id.etConfSenha);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvLogin = findViewById(R.id.tvLogin);

        // Configurar o botão de cadastro
        btnRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (validarCampos())
                {
                    LidarComRegistrar();
                    Intent CpL = new Intent(CadastroActivity.this, LoginActivity.class);
                    startActivity(CpL);
                    finish();
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

    private void LidarComRegistrar()
    {
        url = host + "inserirt.php";
        Ion.with(CadastroActivity.this)
                .load(url)
                .setBodyParameter("usuariox", String.valueOf(etUsuario.getText().toString().isEmpty()))
                .setBodyParameter("emailx", String.valueOf(etEmail.getText().toString().isEmpty()))
                .setBodyParameter("senhax", String.valueOf(etSenha.getText().toString().isEmpty()))
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>()
                {
                    @Override
                    public void onCompleted(Exception e, JsonObject result)
                    {
                        ret = result.get("status").getAsString();
                        if (ret.equals("ok"))
                        {
                            Toast.makeText(getApplicationContext(),
                                    "Cadastro realizado com sucesso!",
                                    Toast.LENGTH_LONG).show();

                            Intent CApL = new Intent(CadastroActivity.this, LoginActivity.class);
                            CadastroActivity.this.startActivity(CApL);

                        } else
                        {
                            Toast.makeText(getApplicationContext(),
                                    "ERRO!!!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void NavegarPraLogin()
    {
        // Navegar para a tela de login
        Intent Logar = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(Logar);
    }

    private boolean EmailValido(String etEmail)
    {
        // Regex para validação básica de email
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(emailPattern, etEmail);
    }

    private boolean validarCampos()
    {
        String nomeUsuario = etUsuario.getText().toString().trim();
        String senhaUsuario = etSenha.getText().toString().trim();
        String emailUsuario = etEmail.getText().toString().trim();

        if (nomeUsuario.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "O nome do usuário é obrigatório", Toast.LENGTH_LONG).show();
            return false;
        }

        if (emailUsuario.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "O e-mail do usuário é obrigatório", Toast.LENGTH_LONG).show();
            return false;
        }

        if (senhaUsuario.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "A senha é obrigatória", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}
