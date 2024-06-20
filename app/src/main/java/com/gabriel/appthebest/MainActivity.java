package com.gabriel.appthebest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarVini( View view ){
        verificarGanhador("vini");
    }

    public void selecionarBellingham( View view ){
        verificarGanhador("bellingham");
    }

    public void selecionarMbappe( View view ){
        verificarGanhador("mbappe");
    }

    public void selecionarMessi( View view ){
        verificarGanhador("messi");
    }

    public void selecionarRonaldo( View view ){
        verificarGanhador("ronaldo");
    }

    public void selecionarHalland( View view ){
        verificarGanhador("halland");
    }

    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"vini", "bellingham", "mbappe", "messi", "ronaldo", "halland"};
        int jogadorAleatorio = new Random().nextInt(5);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[jogadorAleatorio];

        switch ( escolhaApp ){
            case "vini":
                imagemApp.setImageResource( R.drawable.vini);
                break;
            case "bellingham":
                imagemApp.setImageResource( R.drawable.bellingham);
                break;
            case "mbappe":
                imagemApp.setImageResource( R.drawable.mbappe);
                break;
            case "messi":
                imagemApp.setImageResource( R.drawable.messi);
                break;
            case "ronaldo":
                imagemApp.setImageResource( R.drawable.ronaldo);
                break;
            case "halland":
                imagemApp.setImageResource( R.drawable.halland);
                break;
        }

        return escolhaApp;

    }

    private void verificarGanhador(String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "vini" && escolhaUsuario == "halland") ||
                (escolhaApp == "bellingham" && escolhaUsuario == "ronaldo") ||
                (escolhaApp == "mbappe" && escolhaUsuario == "messi") ||
                (escolhaApp == "messi" && escolhaUsuario == "mbappe") ||
                (escolhaApp == "ronaldo" && escolhaUsuario == "bellingham") ||
                (escolhaApp == "halland" && escolhaUsuario == "vini")
        ){ // app ganhador
                textoResultado.setText("Você Perdeu! :(");
        } else if( // Usuario ganhador
               (escolhaUsuario == "vini" && escolhaApp == "halland") ||
               (escolhaUsuario == "bellingham" && escolhaApp == "ronaldo") ||
               (escolhaUsuario == "mbappe" && escolhaApp == "messi") ||
               (escolhaUsuario == "messi" && escolhaApp == "mbappe") ||
               (escolhaUsuario == "ronaldo" && escolhaApp == "bellingham") ||
               (escolhaUsuario == "halland" && escolhaApp == "vini")
        ){
            textoResultado.setText("Você Ganhou!! :)");
        }else{ // Empatou
            textoResultado.setText("Empatamos!!! ;)");
        }

        //   System.out.println("Item clicado :" + escolhaUsuario);
    }

}