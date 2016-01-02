package com.nfcpay.utils;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by FengYang on 2016-01-01.
 */
public class ViewHolder {
    public static <T extends View> T get(View convertView,int viewId){
        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }
        View childView = viewHolder.get(viewId);
        if(childView == null){
            childView = convertView.findViewById(viewId);
            viewHolder.put(viewId,childView);
        }

        return (T)childView;
    }
}
