package com.example.mynavigationview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoadPasswd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoadPasswd extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoadPasswd() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoadPasswd.
     */
    // TODO: Rename and change types and number of parameters
    public static LoadPasswd newInstance(String param1, String param2) {
        LoadPasswd fragment = new LoadPasswd();
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

        View view = inflater.inflate(R.layout.fragment_load_passwd, container, false);
        TextView tvLoadPasswd = view.findViewById(R.id.tvLoadPasswd);
        Button loadPasswd = view.findViewById(R.id.loadPasswd);

        loadPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
                String passwd = preferences.getString("passwd", "No se ha encontrado una clave");
                String time = preferences.getString("time", "No se ha encontrado una hora");

                tvLoadPasswd.setText(" Contraseña: " + passwd + "Hora: " + time);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}