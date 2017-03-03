package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

        @BindView(R.id.farmacia) ImageButton farmacia;
        @BindView(R.id.veterinaria) ImageButton veterinaria;
        @BindView(R.id.gasolinera) ImageButton gasolinera;
        @BindView(R.id.clinica_ortopedia) ImageButton ortopedia;
        @BindView(R.id.parafarmacia) ImageButton parafarmicia;
        @BindView(R.id.clinica_dental) ImageButton clinicaDental;
        @BindView(R.id.medico) ImageButton medico;

        private List<Product> productList = new LinkedList<>();
        private List<Product> productListFinal = new LinkedList<>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            Realm.init(this);


            farmacia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "farmacia");
                    startActivity(i);
                }
            });

            veterinaria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "veterinaria");
                    startActivity(i);
                }
            });

            gasolinera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                }
            });

            ortopedia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "ortopedia");
                    startActivity(i);
                }
            });

            parafarmicia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "parafarmacia");
                    startActivity(i);
                }
            });

            clinicaDental.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "dentista");
                    startActivity(i);
                }
            });

            medico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("categoria", "medico");
                    startActivity(i);
                }
            });
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
            getMenuInflater().inflate(R.menu.menu_main, menu);
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


    }

