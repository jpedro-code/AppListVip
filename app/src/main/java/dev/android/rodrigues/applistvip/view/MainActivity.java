package dev.android.rodrigues.applistvip.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dev.android.rodrigues.applistvip.R;
import dev.android.rodrigues.applistvip.controller.PessoaController;
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

    PessoaController pessoaController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Bem Vindo ao seu app listVip", Toast.LENGTH_LONG).show();

        pessoaController = new PessoaController(this);
        pessoa = new Pessoa();

        editNome = findViewById(R.id.name_edit);
        editSobrenome = findViewById(R.id.sobrenome_edit);
        editNomeCurso = findViewById(R.id.curso_edit);
        editTelefone = findViewById(R.id.phone_ed);

        btnSalvar = findViewById(R.id.button_salvar);
        btnLimpar = findViewById(R.id.button_limpar);
        btnFinalizar = findViewById(R.id.button_finalizar);

        btnLimpar.setOnClickListener(v -> {
            editNome.setText("");
            editSobrenome.setText("");
            editTelefone.setText("");
            editNomeCurso.setText("");
            Toast.makeText(this, "Dados Limpados!", Toast.LENGTH_LONG).show();
            pessoaController.limparDados();
        });

        btnSalvar.setOnClickListener(v -> {
            pessoa.setNome(editNome.getText().toString());
            pessoa.setSobrenome(editSobrenome.getText().toString());
            pessoa.setNomeDoCurso(editNomeCurso.getText().toString());
            pessoa.setPhone(editTelefone.getText().toString());
            Toast.makeText(MainActivity.this, "Seus Dados Foram Salvos Corretamente " + pessoa.getNome(), Toast.LENGTH_SHORT).show();
            pessoaController.salvarDados(pessoa);
            Log.i("BuscarPessoa",pessoaController.buscar(pessoa).toString());
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }


}