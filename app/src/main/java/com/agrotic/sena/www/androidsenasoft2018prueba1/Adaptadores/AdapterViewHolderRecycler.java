package com.agrotic.sena.www.androidsenasoft2018prueba1.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrotic.sena.www.androidsenasoft2018prueba1.R;

public class AdapterViewHolderRecycler extends RecyclerView.ViewHolder {


    ImageView imagenCardView;
    TextView textFechaCardView, textCicloCardView;

    public AdapterViewHolderRecycler(View itemView) {
        super(itemView);
        imagenCardView = itemView.findViewById(R.id.ivImagenCardView);
        textFechaCardView = itemView.findViewById(R.id.tvFechasCardView);
        textCicloCardView = itemView.findViewById(R.id.tvNumCiclosCardView);
    }
}
