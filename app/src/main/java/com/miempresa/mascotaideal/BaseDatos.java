package com.miempresa.mascotaideal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "misiontic";
    private static final String NOMBRE_TABLA_PRODUCTOS="mascotas";
    private static final int VERSION_BASE_DATOS=1;

    public BaseDatos(@Nullable Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key autoincrement," +
                "nombre text," +
                "edad int," +
                "reza text," +
                "tamano text," +
                "usuario int, " +
                "latdata long," +
                "londata long," +
                "ubicacion text)", NOMBRE_TABLA_PRODUCTOS));
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
