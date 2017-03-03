package es.telefonica.talentum.ledapp.view;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.telefonica.talentum.ledapp.DetailsActivity;
import es.telefonica.talentum.ledapp.Product;
import es.telefonica.talentum.ledapp.R;

public class EosLabViewHolder extends RecyclerView.ViewHolder{

    private TextView productName;
    private ImageView productImage;
    private Product product;



    public EosLabViewHolder(View itemView) {
        super(itemView);
        productName= (TextView) itemView.findViewById(R.id.catalogo_row__row);
        productImage= (ImageView) itemView.findViewById(R.id.catalogo_row__image_row);

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product, Context context) {
        this.product = product;
        productName.setText(product.getNombre().toString());
        Picasso.with(context).load(product.getUrl()).into(productImage);
    }

    public void viewDetails(Context context){
        Intent i = new Intent(context, DetailsActivity.class);
        i.putExtra("ref", product.getRef());
        context.startActivity(i);
    }
}
