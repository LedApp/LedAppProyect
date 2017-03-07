package es.telefonica.talentum.ledapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import static es.telefonica.talentum.ledapp.R.menu.menu_main;

public class CatalogoActivity extends AppCompatActivity {
    private GoogleApiClient client;

    @BindView(R.id.farmacia)
    ImageButton farmacia;
    @BindView(R.id.veterinaria)
    ImageButton veterinaria;
    @BindView(R.id.gasolinera)
    ImageButton gasolinera;
    @BindView(R.id.clinica_ortopedia)
    ImageButton ortopedia;
    @BindView(R.id.parafarmacia)
    ImageButton parafarmicia;
    @BindView(R.id.clinica_dental)
    ImageButton clinicaDental;
    @BindView(R.id.medico)
    ImageButton medico;


    private List<Product> productList = new LinkedList<>();
    private List<Product> productListFinal = new LinkedList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo_main);
        ButterKnife.bind(this);
        Realm.init(this);



        farmacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "farmacia");
                startActivity(i);
            }
        });

        veterinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "veterinaria");
                startActivity(i);
            }
        });

        gasolinera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("productList", (Serializable) productListFinal);

                String snackBarText = "Sección disponible próximamente...";
                View rootView = findViewById(android.R.id.content);
                Snackbar mySnackBar = Snackbar.make(rootView, snackBarText, Snackbar.LENGTH_LONG);
                mySnackBar.show();
            }
        });

        ortopedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "ortopedia");
                startActivity(i);
            }
        });

        parafarmicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "parafarmacia");
                startActivity(i);
            }
        });

        clinicaDental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "dentista");
                startActivity(i);
            }
        });

        medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(CatalogoActivity.this, RecyclerView_Activity.class);
                i.putExtra("categoria", "medico");
                startActivity(i);
            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void consultProduct(){
        final ProductApi productApi = new ProductApi();

        productApi.getProduct(this);

        productApi.setOnProductDowloadDataFinish(new ProductApi.ProductDownloadDataFinish() {
            @Override
            public void newProduct(List<Product> productListApi) {

                productList = productListApi;

                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction();
                realm.delete(Product.class);
                for (Product p:productList) {

                    Log.d("nameee", p.getCategoria());
                    realm.copyToRealm(p);

                }

                realm.commitTransaction();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_main_refresh) {

            consultProduct();

            return true;
        }




        return super.onOptionsItemSelected(item);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Catalogo Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}



