package com.miempresa.mascotaideal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ControladorMascotas {

    private BaseDatos db;
    private String NOMBRE_TABLA= "mascotas";

    public ControladorMascotas(Context context){
        db = new BaseDatos(context);
    }

    public ArrayList<Mascota> listarMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase basedatos = db.getReadableDatabase();
        String[] datosConsultar = {"nombre", "raza","edad","ciudad","tamano"};
        Cursor cursor = basedatos.query(
               NOMBRE_TABLA,
               datosConsultar,
               null,
               null,
               null,
               null,
                null
        );

        if (cursor == null) return mascotas;

        if (!cursor.moveToFirst()) return mascotas;

        do{
            String nombre = cursor.getString(0);
            String raza = cursor.getString(1);
            int edad = cursor.getInt(2);
            String ciudad = cursor.getString(3);
            String tamano = cursor.getString(4);
            Mascota m = new Mascota();
            m.setNombre(nombre);
            m.setEdad(edad);
            m.setRaza(raza);
            m.setCiudad(ciudad);
            m.setTamano(tamano);
            mascotas.add(m);

        }while (cursor.moveToNext());

        return mascotas;
    }


    public long agregarMascota(Mascota m){

        SQLiteDatabase basedatos = db.getWritableDatabase();
        ContentValues valoresInsertar = new ContentValues();
        valoresInsertar.put("nombre", m.getNombre());
        valoresInsertar.put("edad", m.getEdad());
        valoresInsertar.put("tamano", m.getTamano());
        valoresInsertar.put("raza", m.getRaza());
        valoresInsertar.put("ciudad",m.getCiudad());
        return basedatos.insert(NOMBRE_TABLA, null, valoresInsertar);

    }

}
