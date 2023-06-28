package dev.android.rodrigues.applistvip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.android.rodrigues.applistvip.R;
import dev.android.rodrigues.applistvip.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    EditText editNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefone;

    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Bem Vindo ao seu app listVip",Toast.LENGTH_LONG).show();

        pessoa = new Pessoa();
        editNome = findViewById(R.id.name_edit);
        editSobrenome = findViewById(R.id.sobrenome_edit);
        editNomeCurso = findViewById(R.id.curso_edit);
        editTelefone = findViewById(R.id.phone_ed);

        btnSalvar = findViewById(R.id.button_salvar);
        btnLimpar = findViewById(R.id.button_limpar);
        btnFinalizar = findViewById(R.id.button_finalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNome.setText("");
                editSobrenome.setText("");
                editTelefone.setText("");
                editNomeCurso.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setNome(editNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setNomeDoCurso(editNomeCurso.getText().toString());
                pessoa.setPhone(editTelefone.getText().toString());
                Toast.makeText(MainActivity.this, "Seus Dados Foram Salvos Corretamente "+ pessoa.getNome(), Toast.LENGTH_SHORT).show();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}