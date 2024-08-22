package com.guimolinas.pedepizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Pedido extends AppCompatActivity {

    private TextView pedidoDetalhado;
    private TextView valorTotal;
    private Button btnNovoPedido;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        // Inicializando as views
        pedidoDetalhado = findViewById(R.id.pedidoDetalhado);
        valorTotal = findViewById(R.id.valorTotal);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);
        btnSair = findViewById(R.id.btnSair);

        // Recuperando os dados enviados da classe Home
        int qtdMussarela = getIntent().getIntExtra("qtdMussarela", 0);
        int qtdCalabresa = getIntent().getIntExtra("qtdCalabresa", 0);
        int qtdBaiana = getIntent().getIntExtra("qtdBaiana", 0);
        int qtdPepperoni = getIntent().getIntExtra("qtdPepperoni", 0);
        int qtdFrango = getIntent().getIntExtra("qtdFrango", 0);
        int qtdEscarola = getIntent().getIntExtra("qtdEscarola", 0);

        double totalPedido = getIntent().getDoubleExtra("totalPedido", 0.0);

        // Preço individual das pizzas
        double precoMussarela = 69.00;
        double precoCalabresa = 47.50;
        double precoBaiana = 59.00;
        double precoPepperoni = 72.00;
        double precoFrango = 72.50;
        double precoEscarola = 63.50;

        // Calculando o valor total para cada tipo de pizza
        double totalMussarela = qtdMussarela * precoMussarela;
        double totalCalabresa = qtdCalabresa * precoCalabresa;
        double totalBaiana = qtdBaiana * precoBaiana;
        double totalPepperoni = qtdPepperoni * precoPepperoni;
        double totalFrango = qtdFrango * precoFrango;
        double totalEscarola = qtdEscarola * precoEscarola;

        // Construindo o resumo do pedido
        StringBuilder resumo = new StringBuilder();
        if (qtdMussarela > 0) {
            resumo.append("Mussarela: ").append(qtdMussarela).append(" unidade(s) - R$ ").append(String.format("%.2f", totalMussarela)).append("\n");
        }
        if (qtdCalabresa > 0) {
            resumo.append("Calabresa: ").append(qtdCalabresa).append(" unidade(s) - R$ ").append(String.format("%.2f", totalCalabresa)).append("\n");
        }
        if (qtdBaiana > 0) {
            resumo.append("Baiana: ").append(qtdBaiana).append(" unidade(s) - R$ ").append(String.format("%.2f", totalBaiana)).append("\n");
        }
        if (qtdPepperoni > 0) {
            resumo.append("Pepperoni: ").append(qtdPepperoni).append(" unidade(s) - R$ ").append(String.format("%.2f", totalPepperoni)).append("\n");
        }
        if (qtdFrango > 0) {
            resumo.append("Frango com Catupiry: ").append(qtdFrango).append(" unidade(s) - R$ ").append(String.format("%.2f", totalFrango)).append("\n");
        }
        if (qtdEscarola > 0) {
            resumo.append("Escarola com Bacon: ").append(qtdEscarola).append(" unidade(s) - R$ ").append(String.format("%.2f", totalEscarola)).append("\n");
        }

        pedidoDetalhado.setText(resumo.toString());
        valorTotal.setText("Valor total: R$ " + String.format("%.2f", totalPedido));

        // Configurando ações dos botões
        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pedido.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);// Finaliza todas as atividades
            }
        });
    }
}
