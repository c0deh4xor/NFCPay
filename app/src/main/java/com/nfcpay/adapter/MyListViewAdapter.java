package com.nfcpay.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.nfcpay.R;
import com.nfcpay.domain.Business;
import com.nfcpay.utils.ViewHolder;

import java.util.List;

/**
 * Created by FengYang on 2016-01-01.
 */
public class MyListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Business> businesses;
    private RequestQueue requestQueue;
    public MyListViewAdapter(Context context, List<Business> businesses) {
        inflater = LayoutInflater.from(context);
        this.businesses = businesses;
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public int getCount() {
        return businesses.size();
    }

    @Override
    public Object getItem(int position) {
        return businesses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.business_item,parent,false);
        }
        final ImageView businessImage = ViewHolder.get(convertView, R.id.id_business_image);
        TextView businessName = ViewHolder.get(convertView,R.id.id_business_name);
        TextView businessDesc = ViewHolder.get(convertView,R.id.id_business_description);
        TextView businessPrice = ViewHolder.get(convertView,R.id.id_business_price);

        Business business = businesses.get(position);
        ImageRequest imageRequest = new ImageRequest(business.getPicUrl(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                businessImage.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("BUSINESS","获取商家图片失败");
            }
        });
        requestQueue.add(imageRequest);
        businessName.setText(business.getName());
        businessDesc.setText(business.getDiscription());
        businessPrice.setText("￥"+business.getPrice());

        return convertView;
    }
}
