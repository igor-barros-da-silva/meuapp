package com.igor.meuapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Musica#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Musica extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public boolean acendida;
    private ImageView botaoMusica;

    public Musica() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Musica.
     */
    // TODO: Rename and change types and number of parameters
    public static Musica newInstance(String param1, String param2) {
        Musica fragment = new Musica();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        acendida = false;

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento = inflater.inflate(R.layout.fragment_musica, container, false);

        botaoMusica = (ImageView) fragmento.findViewById(R.id.musica);
        botaoMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (acendida) apagaMusica();
                else acendeMusica();
            }
        });

        return fragmento;
    }

    public void acendeMusica() {
        botaoMusica.setImageResource(R.drawable.musica2);
        Intent myReprodutor =  new Intent(getActivity(), ServicoMusica.class);
        getActivity().startService(myReprodutor);
        acendida = !acendida;
    }

    public void apagaMusica() {
        botaoMusica.setImageResource(R.drawable.musica);
        Intent myReprodutor =  new Intent(getActivity(), ServicoMusica.class);
        getActivity().stopService(myReprodutor);
        acendida = !acendida;
    }
}