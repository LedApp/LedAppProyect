package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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






        private List<Product> productList = new LinkedList<>();
        private List<Product> productListFinal = new LinkedList<>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            //Flovours

            if (Constants.type == Constants.Type.FREE) {
                Log.i("TAG", "Free version");

            }else {

                Log.i("TAG", "EOSLAB version");

            }


            consultProduct();

            farmacia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFarmacia();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                    startActivity(i);
                }
            });

            veterinaria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getVeterinarias();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
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
                    getOrtopedia();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                    startActivity(i);
                }
            });

            parafarmicia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getParafarmacia();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                    startActivity(i);
                }
            });

            clinicaDental.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getDentista();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                    startActivity(i);
                }
            });

            medico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getMedico();
                    Intent i = new Intent(MainActivity.this, RecyclerView_Activity.class);
                    i.putExtra("productList", (Serializable) productListFinal);
                    startActivity(i);
                }
            });
        }



        public void consultProduct() {
            final ProductApi productApi = new ProductApi();

            productApi.getProduct(this);

            productApi.setOnProductDowloadDataFinish(new ProductApi.ProductDownloadDataFinish() {
                @Override
                public void newProduct(List<Product> productListApi) {

                    productList = productListApi;

                }
            });
        }

        public void getFarmacia() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("farmacia")) {
                    productListFinal.add(p);
                }

            }

        }

        public void getVeterinarias() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("veterinario")) {
                    productListFinal.add(p);
                }

            }

        }

        public void getOrtopedia() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("ortopedia")) {
                    productListFinal.add(p);
                }

            }

        }

        public void getParafarmacia() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("parafarmacia")) {
                    productListFinal.add(p);
                }

            }

        }

        public void getDentista() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("dentista")) {
                    productListFinal.add(p);
                }

            }

        }

        public void getMedico() {
            productListFinal = new LinkedList<>();
            for (Product p : productList) {
                if (p.getCategoria().equals("médico")) {
                    productListFinal.add(p);
                }

            }

        }




    }

