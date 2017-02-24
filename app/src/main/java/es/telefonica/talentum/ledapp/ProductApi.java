package es.telefonica.talentum.ledapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * Created by gemabeltran on 23/2/17.
 */

public class ProductApi {

    public static final String url = "https://demo8112147.mockable.io/";

    public interface ProductDownloadDataFinish{

        public void newProduct(List<Product> productListApi);
    }

    private ProductDownloadDataFinish listener;

    public void setOnProductDowloadDataFinish(ProductDownloadDataFinish listener) {
        this.listener = listener;
    }

    public void getProduct(Context context){

        RequestQueue queue = Volley.newRequestQueue(context);

        Log.d("URL", url);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //all ok

                Log.d("RESPONSE", response);
                parseJSON(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //tenemos un problema
                Log.e("HORROR", "Connection went to shit to the tracks");
            }
        });

        queue.add(request);
    }

    private void parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);
        ProductResponse productResponse = gson.fromJson(reader, ProductResponse.class);
        Log.d("RESPONSE",  productResponse.toString());

        if (listener!=null){

            listener.newProduct(productResponse.getProductList());
        }


    }
}
