package com.igor.meuapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Nivel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Nivel extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SensorManager myManager;
    private Sensor mySensor;
    private NivelPantalha pantalha;

    public Nivel() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Nivel.
     */
    // TODO: Rename and change types and number of parameters
    public static Nivel newInstance(String param1, String param2) {
        Nivel fragment = new Nivel();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            myManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
            mySensor = myManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            int lado = getResources().getDimensionPixelSize(R.dimen.maximo);
            pantalha = new NivelPantalha(getActivity(), lado);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return pantalha;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_nivel, container, false);
    }

    public void onResume(){
        super.onResume();
        myManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void onPause() {
        super.onPause();
        myManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        pantalha.angulos(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}