package com.agrotic.sena.www.androidsenasoft2018prueba1.Persistencia;

import android.content.Context;
import android.content.SharedPreferences;

public class ArchivoDePersistencia {


    public SharedPreferences myFilePersistencia;


    public void guardarDato (Context context, String nombreArchivo, String keyCicloMax, int valorCicloMax,
                             String keyTime, int valorTime){
            myFilePersistencia = context.getSharedPreferences(nombreArchivo, Context.MODE_PRIVATE);
            SharedPreferences.Editor registro = myFilePersistencia.edit();
            registro.putInt(keyCicloMax, valorCicloMax);
            registro.putInt(keyTime, valorTime);
            registro.commit();

    }


    public int [] leerArchivo (Context context, String nombreArchivo, String keyCicloMax, String keyTime){
        int [] valorRetorno = new int[2];
        myFilePersistencia = context.getSharedPreferences(nombreArchivo, Context.MODE_PRIVATE);
        valorRetorno [0] = myFilePersistencia.getInt(keyCicloMax, 2);
        valorRetorno [1] = myFilePersistencia.getInt(keyTime, 1);
        return valorRetorno;

    }


}
