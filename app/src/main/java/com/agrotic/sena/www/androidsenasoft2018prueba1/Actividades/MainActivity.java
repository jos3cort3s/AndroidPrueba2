package com.agrotic.sena.www.androidsenasoft2018prueba1.Actividades;

import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.agrotic.sena.www.androidsenasoft2018prueba1.Fragmentos.AjustesFragment;
import com.agrotic.sena.www.androidsenasoft2018prueba1.Fragmentos.ConteoFragment;
import com.agrotic.sena.www.androidsenasoft2018prueba1.Fragmentos.InformesFragment;
import com.agrotic.sena.www.androidsenasoft2018prueba1.R;

public class MainActivity extends AppCompatActivity {

    FrameLayout colocaFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregaId();
    }

    public void agregaId(){
        colocaFragmento=findViewById(R.id.frameLayoutMain);
    }


    public void agregaFragmento(Fragment fragmento){
        FragmentTransaction administradirFrag = getSupportFragmentManager().beginTransaction();
        administradirFrag.replace(R.id.frameLayoutMain, fragmento).commit();
    }

    public void funcioneBtnMenu(View view){

        switch (view.getId()){

                case R.id. ivBtnConteo:
                    agregaFragmento(new ConteoFragment().newInstance());
                    break;
                case R.id. ivBtnAjustes:
                    agregaFragmento(new AjustesFragment().newInstance());
                    break;
                case R.id. ivBtnInformes:
                    agregaFragmento(new InformesFragment().newInstance());
                    break;
                case R.id. ivBtnSalir:
                    System.exit(0);
                    break;



        }
    }
}
