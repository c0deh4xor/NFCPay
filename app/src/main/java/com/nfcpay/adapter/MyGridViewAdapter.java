package com.nfcpay.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.nfcpay.R;
import com.nfcpay.domain.Function;
import com.nfcpay.utils.ViewHolder;

import java.util.List;

/**
 * Created by FengYang on 2015-12-31.
 */
public class MyGridViewAdapter extends BaseAdapter {

    private List<Function> functions;
    private LayoutInflater inflater;

    public MyGridViewAdapter(Context context, List<Function> funs){
        functions = funs;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return functions.size();
    }

    @Override
    public Object getItem(int position) {
        return functions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item,parent,false);
        }
        ImageView funIcon = ViewHolder.get(convertView, R.id.id_function_icon);
        TextView funName = ViewHolder.get(convertView,R.id.id_function_name);
        Function current = functions.get(position);
        funIcon.setImageBitmap(current.getIcon());
        funName.setText(current.getName());
        return convertView;
    }
}