package com.example.danielbustamante.peluchitosapplication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AgregarFragment extends Fragment {


 private EditText eid, enombre, ecantidad, eprecio;
 private Button badd;
 comunicador interfaz;




    public AgregarFragment() {



    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View view= inflater.inflate(R.layout.fragment_agregar, container, false);
        eid = view.findViewById(R.id.eid);
        enombre = view.findViewById(R.id.enombre);
        ecantidad = view.findViewById(R.id.ecantidad);
        eprecio = view.findViewById(R.id.eprecio);
        badd = view.findViewById(R.id.badd);



        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String id= eid.getText().toString();
                String nombre= enombre.getText().toString();
               String cantidad = ecantidad.getText().toString();
               String precio = eprecio.getText().toString();

                if (id.equals("")|| nombre.equals("")|| cantidad.equals("")|| precio.equals("")){
                    Toast.makeText(getActivity(),"Digite todos los campos", Toast.LENGTH_SHORT).show();
                }else {

                        interfaz.envioDatos(id,nombre,cantidad,precio);
                        eid.equals("");  enombre.equals(""); ecantidad.equals("");  ecantidad.equals("");
                }


        }
        });


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            interfaz = ( comunicador )activity;
        }catch (ClassCastException e){

        }
    }
}
