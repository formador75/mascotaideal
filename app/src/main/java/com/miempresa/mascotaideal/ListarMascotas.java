package com.miempresa.mascotaideal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

        reciclerMacotas.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), reciclerMacotas, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                AlertDialog dialogo = new AlertDialog
                        .Builder(ListarMascotas.this)
                        .setPositiveButton("Si",  (dialog ,which)->{
                            Mascota m = listaMascotas.get(position);
                            Intent i = new Intent(ListarMascotas.this, EditarMascota.class);
                            i.putExtra("id", m.getId());
                            i.putExtra("nombre", m.getNombre());
                            i.putExtra("edad", m.getEdad());
                            i.putExtra("ciudad", m.getCiudad());
                            i.putExtra("raza", m.getRaza());
                            i.putExtra("tamano", m.getTamano());
                            startActivity(i);

                        } )
                        .setNegativeButton("No",  (dialog ,which)->{
                            dialog.dismiss();
                        })
                        .setTitle("Prueba click")
                        .setMessage("prueba click corto")
                        .create();
                dialogo.show();
            }

            @Override
            public void onLongClick(View view, int position) {
                AlertDialog dialogo = new AlertDialog
                        .Builder(ListarMascotas.this)
                        .setPositiveButton("Si",  (dialog ,which)->{
                            //Agregar metodo borrar al controlador
                            Mascota m = listaMascotas.get(position);
                            Log.d("prueba", ""+ m.getId());
                            controladorMascotas.elimarMascota(m);
                            refrescarLista();
                            Toast.makeText(getApplicationContext(), "La mascota se elimino con extio", Toast.LENGTH_LONG).show();


                        } )
                        .setNegativeButton("No",  (dialog ,which)->{
                            dialog.dismiss();
                        })
                        .setTitle("Confirmacion para eliminar")
                        .setMessage("Desea eliminar la mascota")
                        .create();
                dialogo.show();

            }
        }));

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