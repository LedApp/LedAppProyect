package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import es.telefonica.talentum.ledapp.adapter.EosLabAdapter;
import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerView_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Product> productListFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_);

        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = this.getIntent();
        String categoria = intent.getStringExtra("categoria");

        if (categoria.equals("farmacia")){
            getFarmacia();
        }else if (categoria.equals("veterinaria")){
            getVeterinarias();
        }else if (categoria.equals("ortopedia")){
            getOrtopedia();
        }else if (categoria.equals("parafarmacia")){
            getParafarmacia();
        }else if (categoria.equals("dentista")){
            getDentista();
        }else if (categoria.equals("medico")){
            getMedico();
        }


        EosLabAdapter adapter = new EosLabAdapter(this, productListFinal);
        if (productListFinal != null){
            recyclerView.setAdapter(adapter);
        }


    }

    public void getFarmacia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "farmacia").findAll();
        productListFinal = products;

    }
    public void getVeterinarias(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "veterinario").findAll();
        productListFinal = products;

    }

    public void getOrtopedia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "ortopedia").findAll();
        productListFinal = products;

    }

    public void getParafarmacia(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "parafarmacia").findAll();
        productListFinal = products;

    }

    public void getDentista(){
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "dentista").findAll();
        productListFinal = products;

    }

    public void getMedico() {
        productListFinal = new LinkedList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).equalTo("categoria", "médico").findAll();
        productListFinal = products;
    }
}
