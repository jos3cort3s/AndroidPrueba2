package com.agrotic.sena.www.androidsenasoft2018prueba1.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.agrotic.sena.www.androidsenasoft2018prueba1.Adaptadores.AdaptadorLista_Informe;
import com.agrotic.sena.www.androidsenasoft2018prueba1.Adaptadores.AdaptadroRecyclerInformes;
import com.agrotic.sena.www.androidsenasoft2018prueba1.POJOs.PlanaCardViewInforme;
import com.agrotic.sena.www.androidsenasoft2018prueba1.Persistencia.PersistenciaSQLite;
import com.agrotic.sena.www.androidsenasoft2018prueba1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InformesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InformesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listaInformes;



    private OnFragmentInteractionListener mListener;
    RecyclerView listaDeRegistrosRecycler;
    ArrayList<PlanaCardViewInforme> datosLista =  new ArrayList<>();






    public InformesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * //@param param1 Parameter 1.
     * //@param param2 Parameter 2.
     * @return A new instance of fragment InformesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformesFragment newInstance() {
        InformesFragment fragment = new InformesFragment();
        Bundle args = new Bundle();
        /*args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        PersistenciaSQLite mibaseDatos = new PersistenciaSQLite(getContext(), "bd", null, 1);
        ArrayList<PlanaCardViewInforme>  miLista =  mibaseDatos.listarFullDatos();

        AdaptadorLista_Informe miAdapterMista =  new AdaptadorLista_Informe(getContext(), miLista);
        listaInformes.setAdapter(miAdapterMista);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista  = inflater.inflate(R.layout.fragment_informes, container, false);
        setId(vista);

        datosLista.add(new PlanaCardViewInforme("23/12/2018", "23"));
        datosLista.add(new PlanaCardViewInforme("12/01/2018", "85"));
        datosLista.add(new PlanaCardViewInforme("2/12/2018", "53"));
        datosLista.add(new PlanaCardViewInforme("5/4/2018", "12"));
        datosLista.add(new PlanaCardViewInforme("4/05/2018", "32"));
        datosLista.add(new PlanaCardViewInforme("78/03/2018", "45"));




        /*AdaptadroRecyclerInformes adaptador =  new AdaptadroRecyclerInformes(datosLista);
        listaDeRegistrosRecycler.setAdapter(adaptador);
        listaDeRegistrosRecycler.setHasFixedSize(true);
        listaDeRegistrosRecycler.setLayoutManager(new LinearLayoutManager(getContext()));*/

        return vista;
    }



    public void setId(View vista){
        //listaDeRegistrosRecycler  = vista.findViewById(R.id.rvInformeDetalle);
        listaInformes =  vista.findViewById(R.id.lvInformeDetalle);
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
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
