package es.telefonica.talentum.ledapp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import es.telefonica.talentum.ledapp.Product;
import es.telefonica.talentum.ledapp.R;
import es.telefonica.talentum.ledapp.view.EosLabViewHolder;

public class EosLabAdapter extends RecyclerView.Adapter<EosLabViewHolder>{

    private List<Product> productList = new LinkedList<>();
    private LayoutInflater inflater;

    public EosLabAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public EosLabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.catalogo_row, parent, false);
        EosLabViewHolder row = new EosLabViewHolder(view);
        return row;
    }

    @Override
    public void onBindViewHolder(final EosLabViewHolder holder, int position) {
        holder.setProduct(productList.get(position), holder.itemView.getContext());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.viewDetails(holder.itemView.getContext());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
