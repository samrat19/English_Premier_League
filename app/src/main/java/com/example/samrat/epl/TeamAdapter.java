package com.example.samrat.epl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends ArrayAdapter<TeamList> {

    public TeamAdapter(Context context, List<TeamList> TeamLists) {
        super(context, 0, TeamLists);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.team, parent, false);
        }

        TeamList teamList = getItem(position);

        TextView status = (TextView) listItemView.findViewById(R.id.textView11);

        status.setText("Match Day "+" "+teamList.getMaday());

        TextView homeTeam = (TextView) listItemView.findViewById(R.id.hometeam);

        homeTeam.setText(teamList.getHomeTeam());

        TextView awayTeam = (TextView) listItemView.findViewById(R.id.awayteam);

        awayTeam.setText(teamList.getAwayTeam());

        TextView homegoal = (TextView) listItemView.findViewById(R.id.hg);

        String hg = teamList.getHg();


        if(hg.length()==4){
            homegoal.setText("__");
        }else{
            homegoal.setText(""+hg);
        }

        TextView awaygoal = (TextView) listItemView.findViewById(R.id.ag);

        String ag = teamList.getAg();

        if(hg.length()==4){
            awaygoal.setText("__");
        }else{
            awaygoal.setText(""+ag);
        }

        return listItemView;
    }
}
