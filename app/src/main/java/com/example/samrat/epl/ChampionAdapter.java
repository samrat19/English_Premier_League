package com.example.samrat.epl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChampionAdapter extends ArrayAdapter<ChampionList> {

    int club;

    ImageView crest;

    public ChampionAdapter(Activity context, ArrayList<ChampionList> championLists) {

        super(context, 0, championLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.champion, parent, false);
        }

        ChampionList currentAndroidFlavor = getItem(position);

        crest = (ImageView)listItemView.findViewById(R.id.clubImage);

        crest.setImageResource(currentAndroidFlavor.getCimage());

//        club = currentAndroidFlavor.getCimage();



        TextView textView = (TextView)listItemView.findViewById(R.id.textView3);

        textView.setText(currentAndroidFlavor.getYear());

        TextView textView1 = (TextView)listItemView.findViewById(R.id.textView4);

        textView1.setText(currentAndroidFlavor.getClub());


        return listItemView;
    }

    private void loadimage(int poster) {

        Picasso.with(getContext()).load(poster).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(crest, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
