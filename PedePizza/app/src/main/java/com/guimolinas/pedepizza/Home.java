package com.guimolinas.pedepizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    public static EditText edtMussarela;
    public static EditText edtCalabresa;
    public static EditText edtBaiana;
    public static EditText edtPepperoni;
    public static EditText edtFrango;
    public static EditText edtEscarola;

    public static Button btnFinalizarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Certifique-se de que este layout existe

        edtMussarela = (EditText) findViewById(R.id.edtMussarela);
        edtCalabresa = (EditText) findViewById(R.id.edtCalabresa);
        edtBaiana = (EditText) findViewById(R.id.edtBaiana);
        edtPepperoni = (EditText) findViewById(R.id.edtPepperoni);
        edtFrango = (EditText) findViewById(R.id.edtFrango); // Corrigido: não sobrescreva duas vezes
        edtEscarola = (EditText) findViewById(R.id.edtEscarola);

        btnFinalizarPedido = (Button) findViewById(R.id.btnFinalizarPedido);

        btnFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularPedido();
            }
        });
    }

    private void calcularPedido() {
        double precoMussarela = 69.00;
        double precoCalabresa = 47.50;
        double precoBaiana = 59.00;
        double precoPepperoni = 72.00;
        double precoFrango = 72.50;
        double precoEscarola = 63.50;

        int qtdMussarela = getQuantidade(edtMussarela);
        int qtdCalabresa = getQuantidade(edtCalabresa);
        int qtdBaiana = getQuantidade(edtBaiana);
        int qtdPepperoni = getQuantidade(edtPepperoni);
        int qtdFrango = getQuantidade(edtFrango);
        int qtdEscarola = getQuantidade(edtEscarola);

        double totalMussarela = precoMussarela * qtdMussarela;
        double totalCalabresa = precoCalabresa * qtdCalabresa;
        double totalBaiana = precoBaiana * qtdBaiana;
        double totalPepperoni = precoPepperoni * qtdPepperoni;
        double totalFrango = precoFrango * qtdFrango;
        double totalEscarola = precoEscarola * qtdEscarola;

        double totalPedido = totalMussarela + totalCalabresa + totalBaiana +
                totalPepperoni + totalFrango + totalEscarola;

        // Iniciando a próxima Activity e passando os valores
        Intent intent = new Intent(Home.this, Pedido.class);
        intent.putExtra("qtdMussarela", qtdMussarela);
        intent.putExtra("qtdCalabresa", qtdCalabresa);
        intent.putExtra("qtdBaiana", qtdBaiana);
        intent.putExtra("qtdPepperoni", qtdPepperoni);
        intent.putExtra("qtdFrango", qtdFrango);
        intent.putExtra("qtdEscarola", qtdEscarola);
        intent.putExtra("totalPedido", totalPedido);
        startActivity(intent);
    }

    private int getQuantidade(EditText edt) {
        String txt = edt.getText().toString();
        if (txt.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(txt);
        }
    }
}
