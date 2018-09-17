package com.example.danielbustamante.peluchitosapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
        implements comunicador, NavigationView.OnNavigationItemSelectedListener {


    private FragmentManager fm ;
    private FragmentTransaction ft;

    ArrayList<peluchito> peluche= new ArrayList<peluchito>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        AgregarFragment agregarFragment = new AgregarFragment();
        ft.add(R.id.frame, agregarFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ft=fm.beginTransaction();


        if (id == R.id.mAgregar) {
            AgregarFragment agregarFragment = new AgregarFragment();
            ft.replace(R.id.frame, agregarFragment).commit();

            // Handle the camera action
        } else if (id == R.id.mBuscar) {

            BuscarFragment buscarFragment = new BuscarFragment();
            ft.replace(R.id.frame, buscarFragment).commit();

        } else if (id == R.id.mEliminar) {

            EliminarFragment eliminarFragment = new EliminarFragment();
            ft.replace(R.id.frame, eliminarFragment).commit();


        } else if (id == R.id.mInventario) {
           /*  Bundle bundle = new Bundle();
            String resultados = "";

            for (int i = 0; i < peluche.size(); i++)
                if(i + 1 < peluche.size())
                    resultados += peluche.get(i) + " | ";
                else{
                    resultados += peluche.get(i);} */

            InventarioFragment inventarioFragment =  new InventarioFragment();
               // bundle.putString("result", resultados);
                //inventarioFragment.setArguments(bundle);
            ft.replace(R.id.frame, inventarioFragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void envioDatos(String id, String nombre, String cantidad, String precio) {

        peluchito peluchito= new peluchito(id, nombre, cantidad, precio);
        peluche.add(peluchito);
        Toast.makeText(this, "El peluche  "+ nombre + "  Ha sido agregado", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void Eliminar(String eliminar) {
        String pelu=" No Existe ";
        for (int i=0; i<peluche.size(); i++){
            if(peluche.get(i).getNombre().equals(eliminar)) {
                peluche.remove(i);
                pelu=" Destruido ";
                break;


            }

        }
        Toast.makeText(this, "El peluche " + eliminar + pelu, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void buscarP(String buscar) {
        Bundle args= new Bundle();
        String pelu="No existe";
        for (int i=0; i<peluche.size(); i++){
            if(peluche.get(i).getNombre().equals(buscar)){
                //Toast.makeText(this,"ID: "+ peluche.get(i).getId()+     "\nNombre:  "+buscar+" \nCantidad:  "+peluche.get(i).getCantidad()+       "\nPrecio:    "+ peluche.get(i).getPrecio(),Toast.LENGTH_SHORT).show();
              pelu = peluche.get(i).getId()+     "\nNombre:  "+buscar+
                        " \nCantidad:  "+peluche.get(i).getCantidad()+
                        "\nPrecio:"+ peluche.get(i).getPrecio();
//

              //  args.putString("datos",pelu);






            }




        }
        Toast.makeText(this, pelu, Toast.LENGTH_SHORT).show();







    }
}
