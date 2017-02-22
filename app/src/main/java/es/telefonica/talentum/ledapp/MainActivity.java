package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.farmacia) ImageButton farmacia;
    @BindView(R.id.veterinaria) ImageButton veterinaria;
    @BindView(R.id.gasolinera) ImageButton gasolinera;
    @BindView(R.id.clinica_ortopedia) ImageButton ortopedia;
    @BindView(R.id.parafarmacia) ImageButton parafarmicia;
    @BindView(R.id.clinica_dental) ImageButton clinicaDental;
    @BindView(R.id.medico) ImageButton medico;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        farmacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        veterinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        gasolinera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        ortopedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        parafarmicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        clinicaDental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });

        medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                startActivity(i);
            }
        });
    }





}
