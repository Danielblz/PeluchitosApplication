package com.example.danielbustamante.peluchitosapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventarioFragment extends Fragment {

    private TextView tout;

    public InventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);
        tout = view.findViewById(R.id.tout);
        Bundle bundle = getArguments();
    //String result = bundle.getString("result");

            //tout.setText(result);

        // Inflate the layout for this fragment
        return view;
    }

}
