package com.miempresa.mascotaideal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarMascota extends AppCompatActivity {

    ControladorMascotas controladorMascotas;
    Button agregar;
    EditText etNombre, etRaza, etTamano, etEdad, etCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);
        agregar = findViewById(R.id.button2);
        controladorMascotas = new ControladorMascotas(getApplicationContext());
        etNombre = findViewById(R.id.etnombrein);
        etRaza = findViewById(R.id.etrazain);
        etEdad = findViewById(R.id.etedadin);
        etTamano = findViewById(R.id.ettamanoin);
        etCiudad = findViewById(R.id.etciudadin);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                Log.d("prueba", "" + edad);
                String raza = etRaza.getText().toString();
                String tamano = etTamano.getText().toString();
                String ciudad = etCiudad.getText().toString();

                Mascota m = new Mascota();
                m.setNombre(nombre);
                m.setCiudad(ciudad);
                m.setTamano(tamano);
                m.setEdad(edad);
                m.setRaza(raza);

                controladorMascotas.agregarMascota(m);

                Toast.makeText(getApplicationContext(), "La mascota se agrego con extio", Toast.LENGTH_LONG).show();
                etNombre.setText("");
                etRaza.setText("");
                etEdad.setText("");
                etTamano.setText("");
                etCiudad.setText("");



            }
        });



    }
}