package br.usjt.cursoandroid2015.aeronaveprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by palomacarreira on 07/09/15.
 */
public class ListaPassagemActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_passagem);

        Selecao selecao = new Selecao();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);

        ArrayList<Passagem> lista = selecao.listarTodasPassagens(origem, destino);

        //cria o texto da view
        TextView textView = (TextView) findViewById(R.id.txt_lista_passagem);
        String message = "";
        for(Passagem passagem:lista){
            message += passagem.getOrigem() + "-" + passagem.getDestino() + "-" + passagem.getHorarioSaida() + "-" + passagem.getPreco() + "\n";
        }
        if(message.length() == 0) {
            message = "Nenhuma passagem encontrada para o critério escolhido.";
            textView.setLines(3);
        } else {
            textView.setLines(lista.size());
        }
        textView.setText(message);
    }

}
