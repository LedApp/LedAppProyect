package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.activity_details_titulo) TextView titulo;
    @BindView(R.id.activity_details_referencia) TextView referencia;
    @BindView(R.id.details___cruz) TextView cruz;
    @BindView(R.id.details___horario) TextView horario;
    @BindView(R.id.details___brillo) TextView brillo;
    @BindView(R.id.details___fuente) TextView fuente;
    @BindView(R.id.details___control) TextView control;
    @BindView(R.id.details___tipografia) TextView tipografia;
    @BindView(R.id.details___consumo) TextView consumo;
    @BindView(R.id.details___voltaje) TextView voltaje;
    @BindView(R.id.details___almacenamiento) TextView almacenamiento;
    @BindView(R.id.details___trabajo) TextView trabajo;
    @BindView(R.id.details___pixeles) TextView pixeles;
    @BindView(R.id.activity_details_imagen) ImageView imagen;
    @BindView(R.id.activity_details_caracteristicas_button) Button caracteristcasButton;
    @BindView(R.id.activity_details_especificaciones_button) Button especificacionesButton;
    @BindView(R.id.caracteristicas) LinearLayout caracteristicas;
    @BindView(R.id.especificaciones) LinearLayout especificaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String ref =  intent.getStringExtra("ref");

        especificaciones.setVisibility(View.INVISIBLE);


        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> product = realm.where(Product.class).equalTo("ref", ref).findAll();

        titulo.setText(product.get(0).getNombre());
        referencia.setText(product.get(0).getRef());
        Picasso.with(this).load(product.get(0).getUrl()).into(imagen);
        cruz.setText(product.get(0).getCruz());
        horario.setText(product.get(0).getHorario());
        brillo.setText(product.get(0).getBrillo());
        fuente.setText(product.get(0).getFuente());
        control.setText(product.get(0).getContol());
        tipografia.setText(product.get(0).getTipografia());
        consumo.setText(product.get(0).getConsumo());
        voltaje.setText(product.get(0).getVoltaje());
        almacenamiento.setText(product.get(0).getAlmacenamiento());
        trabajo.setText(product.get(0).getTrabajo());
        pixeles.setText(product.get(0).getPixeles());

        especificacionesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                caracteristicas.setVisibility(View.INVISIBLE);
                especificaciones.setVisibility(View.VISIBLE);
                Animation animation   =    AnimationUtils.loadAnimation(v.getContext(), R.anim.anim1);
                animation.setDuration(500);
                especificaciones.setAnimation(animation);
                especificaciones.animate();
                animation.start();
            }
        });

        caracteristcasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                especificaciones.setVisibility(View.INVISIBLE);
                caracteristicas.setVisibility(View.VISIBLE);
                Animation animation   =    AnimationUtils.loadAnimation(v.getContext(), R.anim.anim1);
                animation.setDuration(500);
                caracteristicas.setAnimation(animation);
                caracteristicas.animate();
                animation.start();
            }
        });



    }
}
