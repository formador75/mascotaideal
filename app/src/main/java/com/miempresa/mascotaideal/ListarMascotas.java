package com.miempresa.mascotaideal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListarMascotas extends AppCompatActivity {

    RecyclerView reciclerMacotas;
    AdaptadorMascotas adaptadorMascotas;
    List<Mascota> listaMascotas;
    ControladorMascotas controladorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mascotas);
        reciclerMacotas = findViewById(R.id.reciclermascotas);
        listaMascotas = new ArrayList<>();
        controladorMascotas = new ControladorMascotas(getApplicationContext());
        adaptadorMascotas = new AdaptadorMascotas(listaMascotas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        reciclerMacotas.setLayoutManager(mLayoutManager);
        reciclerMacotas.setItemAnimator(new DefaultItemAnimator());
        reciclerMacotas.setAdapter(adaptadorMascotas);
        refrescarLista();

    }

    @Override
    protected void onResume() {
        super.onResume();
        refrescarLista();
    }

    public void refrescarLista(){
        if(controladorMascotas == null) return;

        listaMascotas = controladorMascotas.listarMascotas();
        adaptadorMascotas.setListaMascotas(listaMascotas);
        adaptadorMascotas.notifyDataSetChanged();


    }

}