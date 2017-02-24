package es.telefonica.talentum.ledapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import es.telefonica.talentum.ledapp.adapter.EosLabAdapter;

public class RecyclerView_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_);

        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = this.getIntent();
        List<Product> products = (List<Product>) intent.getSerializableExtra("productList");

        EosLabAdapter adapter = new EosLabAdapter(this, products);
        if (products != null){
            recyclerView.setAdapter(adapter);
        }


    }
}
