package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.List;

import es.telefonica.talentum.ledapp.adapter.EosLabAdapter;
import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerView_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Product> productListFinal;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_recycler_view_);

        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = this.getIntent();
        String categoria = intent.getStringExtra("categoria");

        if (categoria.equals("farmacia")){
            getFarmacia();
            getSupportActionBar().setTitle("Farmacia");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.farmaciaColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.farmaciaColor));

        }else if (categoria.equals("veterinaria")){
            getVeterinarias();
            getSupportActionBar().setTitle("Veterinario");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.veterinarioColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.veterinarioColor));
        }else if (categoria.equals("ortopedia")){
            getOrtopedia();
            getSupportActionBar().setTitle("Ortopedia");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.ortopediaColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.ortopediaColor));
        }else if (categoria.equals("parafarmacia")){
            getParafarmacia();
            getSupportActionBar().setTitle("Parafarmacia");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.parafarmaciaColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.parafarmaciaColor));
        }else if (categoria.equals("dentista")){
            getDentista();
            getSupportActionBar().setTitle("Dental");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dentalColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.dentalColor));
        }else if (categoria.equals("medico")){
            getMedico();
            getSupportActionBar().setTitle("Centro Médico");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.medicoColor)));
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.medicoColor));
        }


        EosLabAdapter adapter = new EosLabAdapter(this, productListFinal);
        if (productListFinal != null){
            recyclerView.setAdapter(adapter);
        }
    }

    public void getFarmacia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 1).findAll();
        productListFinal = products;

    }
    public void getVeterinarias(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 2).findAll();
        productListFinal = products;

    }

    public void getOrtopedia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 4).findAll();
        productListFinal = products;

    }

    public void getParafarmacia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 5).findAll();
        productListFinal = products;

    }

    public void getDentista(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 6).findAll();
        productListFinal = products;

    }

    public void getMedico() {
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", 7).findAll();
        productListFinal = products;
    }
}
