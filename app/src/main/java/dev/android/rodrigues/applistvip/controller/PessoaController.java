package dev.android.rodrigues.applistvip.controller;

import android.content.SharedPreferences;
import android.util.Log;

import dev.android.rodrigues.applistvip.model.Pessoa;
import dev.android.rodrigues.applistvip.view.MainActivity;

public class PessoaController {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String NOME_PREFERENCIAS = "preferencias";

    public PessoaController(MainActivity mainActivity){
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCIAS,0);
        editor = sharedPreferences.edit();
    }

    public void salvarDados(Pessoa pessoa){
        editor.putString("nome",pessoa.getNome());
        editor.putString("sobrenome",pessoa.getSobrenome());
        editor.putString("curso",pessoa.getNomeDoCurso());
        editor.putString("telefone",pessoa.getPhone());
        editor.apply();
        Log.i("Controller_MVC","Salvo com sucesso : " + pessoa.getNome());
    }
    public void limparDados(){
        editor.clear();
        editor.apply();
    }

    public Pessoa buscar(Pessoa pessoa){
        pessoa.setNome(sharedPreferences.getString("nome","NA"));
        pessoa.setSobrenome(sharedPreferences.getString("sobrenome","NA"));
        pessoa.setNomeDoCurso(sharedPreferences.getString("curso","NA"));
        pessoa.setPhone(sharedPreferences.getString("telefone","NA"));
        return pessoa;
    }
}
