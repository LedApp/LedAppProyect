package es.telefonica.talentum.ledapp.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import es.telefonica.talentum.ledapp.R;

public class EosLabViewHolder extends RecyclerView.ViewHolder{

    private TextView productName;
    private ImageView productImage;




    public EosLabViewHolder(View itemView) {
        super(itemView);
        productName= (TextView) itemView.findViewById(R.id.catalogo_row__row);
        productImage= (ImageView) itemView.findViewById(R.id.catalogo_row__image_row);

    }




}
