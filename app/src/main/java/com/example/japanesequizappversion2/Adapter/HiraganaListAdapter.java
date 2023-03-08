package com.example.japanesequizappversion2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.japanesequizappversion2.Model.HiraganaModel;
import com.example.japanesequizappversion2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HiraganaListAdapter extends ArrayAdapter<HiraganaModel> {

    // constructor for our list view adapter.
    public HiraganaListAdapter(@NonNull Context context, ArrayList<HiraganaModel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_hiragana_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        HiraganaModel dataModel = getItem(position);

        // initializing our UI components of list view item.
        TextView textView = listitemView.findViewById(R.id.tvHiragana);
        ImageView imageView = listitemView.findViewById(R.id.imageHiragana);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        textView.setText(dataModel.getTextModel());

        // in below line we are using Picasso to load image
        // from URL in our Image VIew.
        Picasso.get().load(dataModel.getImgUrl()).into(imageView);

        // below line is use to add item
        // click listener for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModel.getTextModel(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;
    }
}
