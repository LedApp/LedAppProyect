package es.telefonica.talentum.ledapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.activity_details_titulo) TextView titulo;
    @BindView(R.id.activity_details_referencia) TextView referencia;
    @BindView(R.id.activity_details_mostrar_caracteristicas_y_especificaciones) TextView caracteristicasYEspecificaciones;
    @BindView(R.id.activity_details_caracteristicas_button) Button caracteristcasButton;
    @BindView(R.id.activity_details_especificaciones_button) Button especificacionesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        
    }
}
