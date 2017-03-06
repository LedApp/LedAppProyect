package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

        @BindView(R.id.main_view__catalogo) Button catalogo;
        @BindView(R.id.main_view__about_us) ImageButton information;
        @BindView(R.id.main_view__web) TextView web;
        @BindView(R.id.main_view__phone) TextView phone;
        @BindView(R.id.main_view__correo) TextView correo;

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

            web.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("http://www.eoslab.com/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("tel:" + "691494242");
                    Intent intent = new Intent (Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                }
            });

            correo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:dpino@eoslab.com?subject=Asunto:" + "" + "&body=" + "");
                    intent.setData(data);
                    startActivity(intent);
                }
            });



        }
    }

