package com.caiomontenegro.projeto_pedrapapeltesoura;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verficicarGanhador("pedra");   // chamando o método verficicarGanhador()
    }

    public void selecionarPapel(View view){
        verficicarGanhador("papel");   // chamando o método verficicarGanhador()
    }

    public void selecionarTesoura(View view){
        verficicarGanhador("tesoura");   // chamando o método verficicarGanhador()
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};            //     É o mesmo que: Random random = new Random();
        int numeroAleatorio = new Random().nextInt(3);       // <--                 random.nextInt();
        ImageView imagemApp = findViewById(R.id.image_app);

        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            // Case para exibir a imagem pedra
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            // Case para exibir a imagem papel
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            // Case para exibir a imagem tesoura
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;                                          // Precisa do return porque esse método é do tipo que precisa retorna algo
    }

    // Esse método será chamado em outro método, na imagem que for clicada.
    private void verficicarGanhador( String escolhaUsuario ){
        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.text_resultado);
        // Estrutura condicional para mostrar o resultado na tela
        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")  ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")    ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){
            // App ganha
            textoResultado.setText("Você perdeu :(");
        } else if (
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")  ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra")    ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ) {
            // Usuário ganha
            textoResultado.setText("Você ganhou :)");

        } else {
            // Haja empate
            textoResultado.setText("Empatamos ;)");
        }
    }
}