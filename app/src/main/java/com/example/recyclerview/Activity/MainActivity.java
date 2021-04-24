package com.example.recyclerview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.Adapter.Adapter;
import com.example.recyclerview.Model.Filmes;
import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Filmes> listFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Configurar Adaptador
        Adapter adapter = new Adapter(listFilmes);

        //Gerar Lista de Filmes
        criarFilmes();

        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Configurar evento de clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filmes filmes = listFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Filme selecionado: " + filmes.getTitulo(),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filmes filmes = listFilmes.get(position);
                Toast.makeText(getApplicationContext(), "Filme longamente selecionado: " + filmes.getTitulo(),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    public void criarFilmes(){

        Filmes filmes = new Filmes("Homem Aranha - De volta ao lar", "2017", "Aventura");
        listFilmes.add(filmes);

        filmes = new Filmes("Mulher Maravilha", "2017", "Fantasia");
        listFilmes.add(filmes);

        filmes = new Filmes("Liga da Justiça", "2017", "Ficção");
        listFilmes.add(filmes);

        filmes = new Filmes("Capitão América - Guerra Civíl", "2017", "Aventura/Ficção");
        listFilmes.add(filmes);

        filmes = new Filmes("It - A Coisa", "2017", "Drama/Terror");
        listFilmes.add(filmes);

        filmes = new Filmes("Pica-Pau", "2017", "Comédia/Animação");
        listFilmes.add(filmes);

    }
}