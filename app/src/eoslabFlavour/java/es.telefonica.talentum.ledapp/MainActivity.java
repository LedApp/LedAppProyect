package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

        @BindView(R.id.main_view__catalogo) Button catalogo;
        @BindView(R.id.main_view__about_us) ImageButton information;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            //Flovours

            if (Constants.type == Constants.Type.FREE) {
                Log.i("TAG", "Free version");

            } else {

                Log.i("TAG", "EOSLAB version");

            }

            catalogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, CatalogoActivity.class);
                    startActivity(i);


                }
            });





        }
    }

