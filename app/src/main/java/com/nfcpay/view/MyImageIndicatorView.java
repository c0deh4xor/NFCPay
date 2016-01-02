package com.nfcpay.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.panxw.android.imageindicator.ImageIndicatorView;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by FengYang on 2015-12-30.
 */
public class MyImageIndicatorView extends ImageIndicatorView {
    private int viewCount = 0;

    public MyImageIndicatorView(Context context) {
        super(context);
    }

    public MyImageIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addViewItem(View view) {
        super.addViewItem(view);
        viewCount++;
        getViewPager().getAdapter().notifyDataSetChanged();
    }

    @Override
    public int getTotalCount() {
        return viewCount;
    }

    public void setupLayoutByUrls(final String[] urls){
        if(urls == null){
            throw new NullPointerException("urls can't be null");
        }
        setupLayoutByUrls(urls);
    }

    public void setupLayoutByUrls(final List<String> urls){
        Log.e("TAG","setupLayoutByUrls");
        if(urls == null){
            throw new NullPointerException("urls can't be null");
        }
        final int len = urls.size();
        if (len > 0) {
            RequestQueue queue = Volley.newRequestQueue(getContext());
            for (int i = 0; i < len; i++) {
                Log.e("TAG","i="+i);
                final ImageView item = new ImageView(getContext());
                item.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageRequest imageRequest = new ImageRequest(urls.get(i), new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        Log.e("TAG", "得到图片");
                        item.setImageBitmap(response);
                        addViewItem(item);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG","未得到图片");
                    }
                });
                queue.add(imageRequest);
            }
        }
    }

    private Drawable loadImageFromNetwork(String imageUrl)
    {
        Drawable drawable = null;
        try {
            // 可以在这里通过文件名来判断，是否本地有此图片
            drawable = Drawable.createFromStream(
                    new URL(imageUrl).openStream(), "image.jpg");
        } catch (IOException e) {
            Log.d("test", e.getMessage());
        }
        if (drawable == null) {
            Log.d("test", "null drawable");
        } else {
            Log.d("test", "not null drawable");
        }

        return drawable ;
    }
}
