package com.example.mynavigationview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavePasswd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavePasswd extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SavePasswd() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavePasswd.
     */
    // TODO: Rename and change types and number of parameters
    public static SavePasswd newInstance(String param1, String param2) {
        SavePasswd fragment = new SavePasswd();
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

        View view = inflater.inflate(R.layout.fragment_save_passwd, container, false);
        EditText etSavePasswd = view.findViewById(R.id.etSavePasswd);
        Button savePasswd = view.findViewById(R.id.savePasswd);

        savePasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwd = etSavePasswd.getText().toString();
                SharedPreferences preferences = getActivity().getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

                Calendar calendar = Calendar.getInstance();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("passwd", passwd);
                String time = calendar.getTime().toString();
                editor.putString("time", time);
                editor.apply();

                Toast toast = Toast.makeText(view.getContext(), "Se ha guardado la contraseña", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}