package com.agrotic.sena.www.androidsenasoft2018prueba1.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrotic.sena.www.androidsenasoft2018prueba1.POJOs.PlanaCardViewInforme;
import com.agrotic.sena.www.androidsenasoft2018prueba1.R;

import java.util.ArrayList;

public class AdaptadroRecyclerInformes extends RecyclerView.Adapter<AdapterViewHolderRecycler>{


    public ArrayList<PlanaCardViewInforme> arrayListDatosRecycler;


    public AdaptadroRecyclerInformes(ArrayList<PlanaCardViewInforme> arrayListDatosRecycler) {
        this.arrayListDatosRecycler = arrayListDatosRecycler;
    }

    @NonNull
    @Override
    public AdapterViewHolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View visttaInflar = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view_informe, parent, false);
        return new AdapterViewHolderRecycler(visttaInflar);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolderRecycler holder, int position) {
        holder.textCicloCardView.setText(arrayListDatosRecycler.get(position).getCiclos());
        holder.textFechaCardView.setText(arrayListDatosRecycler.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return  arrayListDatosRecycler.size();
    }
}
