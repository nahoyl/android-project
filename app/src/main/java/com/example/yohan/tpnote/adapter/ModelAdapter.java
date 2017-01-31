package com.example.yohan.tpnote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.model.Image;

import java.util.List;

/**
 * Created by Yohan on 27/01/2017.
 */

public class ModelAdapter extends ArrayAdapter<Image> {

    public ModelAdapter(Context context, List<Image> liste){
        super(context, 0 , liste);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste, null);
        }

        ItemImageViewHolder viewHolder = (ItemImageViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ItemImageViewHolder();
            viewHolder.itemImage = (ImageView)convertView.findViewById(R.id.imageImage);
            viewHolder.itemDescription = (TextView)convertView.findViewById(R.id.descriptionImage);
            viewHolder.itemNom = (TextView)convertView.findViewById(R.id.nomImage);
            convertView.setTag(viewHolder);
        }

        Image image = getItem(position);

        viewHolder.itemNom.setText(image.getNom());
        viewHolder.itemDescription.setText(image.getDescription());
        //Convertir to bitmap
        viewHolder.itemImage.setImageBitmap(image.getImgBmp());


        return convertView;

    }

    private class ItemImageViewHolder {
        public TextView itemDescription;
        public TextView itemNom;
        public ImageView itemImage;
    }
}
