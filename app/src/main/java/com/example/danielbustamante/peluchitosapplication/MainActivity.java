package com.example.danielbustamante.peluchitosapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements comunicador{



    private FragmentManager fm ;
    private FragmentTransaction ft;

    ArrayList<peluchito> peluche= new ArrayList<peluchito>();


    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm= getSupportFragmentManager();
        ft = fm.beginTransaction();

        AgregarFragment agregarFragment = new AgregarFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


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
        for (int i=0; i<peluche.size(); i++){
            if(peluche.get(i).getNombre().equals(buscar)){
               // Toast.makeText(this,"ID: "+ peluche.get(i).getId()+     "\nNombre:  "+buscar+" \nCantidad:  "+peluche.get(i).getCantidad()+                       "\nPrecio:    "+ peluche.get(i).getPrecio(),Toast.LENGTH_SHORT).show();
//
                args.putString("id", peluche.get(i).getId());
                args.putString("nombre", buscar);
                args.putString("cantidad",peluche.get(i).getCantidad());
                args.putString("precio", peluche.get(i).getPrecio());

                BuscarFragment buscarFragment = new BuscarFragment();
                buscarFragment.setArguments(args);
                ft = fm.beginTransaction();
                ft.replace(android.R.id.content, buscarFragment).commit();
            }



        }
      //  Toast.makeText(this, "El peluche: "+ buscar + "No existe", Toast.LENGTH_SHORT).show();

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){

                case 0: AgregarFragment tab0 = new AgregarFragment();
                return tab0;
                case 1: BuscarFragment tab1= new BuscarFragment();
                return tab1;
                case  2: EliminarFragment tab2 = new EliminarFragment();
                return tab2;
                case 3: InventarioFragment tab3 = new InventarioFragment();
                return tab3;

                default:
                    return null;
            }


        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }
}
