package com.miempresa.mascotaideal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgregarMascota extends AppCompatActivity {

    ControladorMascotas controladorMascotas;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);
        agregar = findViewById(R.id.button2);
        controladorMascotas = new ControladorMascotas(getApplicationContext());

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mascota m = new Mascota();
                m.setNombre("tito");
                m.setCiudad("Bucaramanga");
                m.setTamano("pequeño");
                m.setEdad(2);
                m.setRaza("angora");

                controladorMascotas.agregarMascota(m);

            }
        });



    }
}