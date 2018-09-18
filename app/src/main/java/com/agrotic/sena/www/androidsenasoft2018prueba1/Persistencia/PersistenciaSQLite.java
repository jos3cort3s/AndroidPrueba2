package com.agrotic.sena.www.androidsenasoft2018prueba1.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.agrotic.sena.www.androidsenasoft2018prueba1.POJOs.PlanaCardViewInforme;

import java.util.ArrayList;
import java.util.List;

public class PersistenciaSQLite extends SQLiteOpenHelper {


    public static final String NOMBRE_BASE_DATOS = "base_datos_ciclos";
    public  final String TABLA_CICLOS = "ciclos";
    public  final String KEY_ID_CILOS = "id_ciclos";
    public  final String KEY_NUM_CICLOS = "num_ciclos";
    public  final String KEY_FECHA_CICLOS = "fecha_ciclos";


    public  final String sentenciaCreaTablaSQL = "Create Table "+ TABLA_CICLOS + " (" +
            KEY_ID_CILOS + " Integer  primary key autoincrement, "+
            KEY_NUM_CICLOS + " text, "+
            KEY_FECHA_CICLOS+ " text)";


    public PersistenciaSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMBRE_BASE_DATOS, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sentenciaCreaTablaSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    SQLiteDatabase miBaseDeDatos;

    public void abrirDataBase (boolean escritura){
        if(escritura)miBaseDeDatos=this.getWritableDatabase();
        else miBaseDeDatos=this.getReadableDatabase();
    }

    public void cerrarDataBase(){
        miBaseDeDatos.close();
    }


    public long  insertarDato (PlanaCardViewInforme datoInsertar){
        abrirDataBase(true);

        ContentValues cvInsertar = new ContentValues();
        cvInsertar.put(KEY_NUM_CICLOS, datoInsertar.getCiclos());
        cvInsertar.put(KEY_FECHA_CICLOS, datoInsertar.getFecha());

        long insertTrue =  miBaseDeDatos.insert(TABLA_CICLOS, null, cvInsertar);

        cerrarDataBase();

        return  insertTrue;
    }


    public ArrayList<PlanaCardViewInforme> listarFullDatos (){

        abrirDataBase(false);
        String consultaSelFull =  "Select * from ciclos";
        String ciclos ,  fechas;

        ArrayList<PlanaCardViewInforme> datos  = new ArrayList<>();
        PlanaCardViewInforme objetoSolo;

        Cursor cursor =  miBaseDeDatos.rawQuery(consultaSelFull, null);

        if (cursor != null && cursor.moveToFirst()){
             do {
                 ciclos = cursor.getString(1);
                 fechas = cursor.getString(2);

                 objetoSolo =  new PlanaCardViewInforme(ciclos, fechas);
                 datos.add(objetoSolo);
             }while (cursor.moveToNext());


        }
        cerrarDataBase();
        return datos;

    }
}
