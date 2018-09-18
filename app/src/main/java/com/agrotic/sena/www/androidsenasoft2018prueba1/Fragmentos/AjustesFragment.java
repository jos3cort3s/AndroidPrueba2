package com.agrotic.sena.www.androidsenasoft2018prueba1.Fragmentos;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.agrotic.sena.www.androidsenasoft2018prueba1.Persistencia.ArchivoDePersistencia;
import com.agrotic.sena.www.androidsenasoft2018prueba1.R;
import com.agrotic.sena.www.androidsenasoft2018prueba1.Utils.VariablesUtil;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AjustesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AjustesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Spinner spConteoMaximo, spRetardo;
    Button btnSave;
    ToggleButton btnToggleOnOff;
    int ciclosMax = 10, tiempo = 5;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

     ArchivoDePersistencia persistenciaMy;
    String archivoPer =  "ArchivoPer";

    OnFragmentInteractionListener mListener;

    public AjustesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * //@param param1 Parameter 1.
     * //@param param2 Parameter 2.
     * @return A new instance of fragment AjustesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AjustesFragment newInstance() {
        AjustesFragment fragment = new AjustesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaAjustes =  inflater.inflate(R.layout.fragment_ajustes, container, false);
        agregaId(vistaAjustes);
        listenerSpinner();



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArchivoDePersistencia persistenciaAjustes =  new ArchivoDePersistencia();
                persistenciaAjustes.guardarDato(getContext(), "FilePersistencia",
                        "cicloMax",  ciclosMax, "tiempo", tiempo);


                Log.e("VALOR_CICLOS", String.valueOf(persistenciaAjustes.leerArchivo(getContext(),
                        "FilePersistencia", "cicloMax", "tiempo")[0]));
                Log.e("VALOR_TIEMPO", String.valueOf(persistenciaAjustes.leerArchivo(getContext(),
                        "FilePersistencia", "cicloMax", "tiempo")[1]));



               /* SharedPreferences guarda = getActivity().getSharedPreferences("DataCiclos",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor shareEditar =  guarda.edit();
                shareEditar.putInt("keyConteoMax", ciclosMax);
                shareEditar.putInt("keyRetardo", tiempo);
                shareEditar.commit();*/

            }
        });



        return vistaAjustes;
    }


    public void listenerButton (){


    }



    public void listenerSpinner(){

        spConteoMaximo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 ciclosMax = (position*5);}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spRetardo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tiempo = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    public void agregaId(View view ){
        spConteoMaximo = view.findViewById(R.id.spConteoMax);
        spRetardo = view.findViewById(R.id.spRetardoTime);
        btnToggleOnOff = view.findViewById(R.id.btnToggleOnOff);
        btnSave = view.findViewById(R.id.btnGurdaAjuste);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  /*  @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
