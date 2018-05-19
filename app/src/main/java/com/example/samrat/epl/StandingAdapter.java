package com.example.samrat.epl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StandingAdapter extends ArrayAdapter<StandingList> {


    public StandingAdapter(Context context, List<StandingList> standingLists) {
        super(context, 0, standingLists);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.barclays_standings, parent, false);
        }

        StandingList standingList = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.textView);

        nameTextView.setText(standingList.getName());

        TextView point =(TextView) listItemView.findViewById(R.id.textView2);

        point.setText(standingList.getRank());

        return listItemView;
    }
}

