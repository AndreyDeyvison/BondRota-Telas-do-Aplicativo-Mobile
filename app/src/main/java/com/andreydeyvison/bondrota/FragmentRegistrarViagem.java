package com.andreydeyvison.bondrota;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRegistrarViagem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistrarViagem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Spinner spinnerFaculdadeIda;
    private Spinner spinnerFaculdadeVolta;
    private Spinner spinnerPontoEmbarque;

    // ArrayLists para as opções
    private ArrayList<String> faculdades = new ArrayList<>();
    private ArrayList<String> pontosDeEmbarque = new ArrayList<>();


    public FragmentRegistrarViagem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegistrarViagem.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistrarViagem newInstance(String param1, String param2) {
        FragmentRegistrarViagem fragment = new FragmentRegistrarViagem();
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
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrar_viagem, container, false);

        inicializarComponentes(view);
        configurarListasOpcoes();
        configurarSpinners();

        // Inflate the layout for this fragment
        return view;
    }


    private void inicializarComponentes(View view) {
        spinnerFaculdadeIda = view.findViewById(R.id.spinnerFaculdadeIda);
        spinnerFaculdadeVolta = view.findViewById(R.id.spinnerFaculdadeVolta);
        spinnerPontoEmbarque = view.findViewById(R.id.spinnerPontoDeEmbarque);

    }

    private void configurarListasOpcoes() {
        faculdades.add("UNIMA - AFYA");
        faculdades.add("Estácio");
        faculdades.add("UMJ");
        faculdades.add("IFAL");

        pontosDeEmbarque.add("Ponto 1 - Cidade 1");
        pontosDeEmbarque.add("Ponto 2 - Cidade 1");
        pontosDeEmbarque.add("Ponto 3 - Cidade 1");
        pontosDeEmbarque.add("Ponto 1 - Cidade 2");
        pontosDeEmbarque.add("Ponto 2 - Cidade 2");
    }

    private void configurarSpinners() {

        ArrayAdapter<String> adapterFaculdadeIda = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,faculdades
        );
        adapterFaculdadeIda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFaculdadeIda.setAdapter(adapterFaculdadeIda);

        ArrayAdapter<String> adapterFaculdadeVolta = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,faculdades
        );
        adapterFaculdadeVolta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFaculdadeVolta.setAdapter(adapterFaculdadeVolta);

        ArrayAdapter<String> adapterPontoEmbarque = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,pontosDeEmbarque
        );
        adapterPontoEmbarque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPontoEmbarque.setAdapter(adapterPontoEmbarque);

    }

}