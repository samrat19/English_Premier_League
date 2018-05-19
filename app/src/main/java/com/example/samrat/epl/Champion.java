package com.example.samrat.epl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Champion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        ListView listView = (ListView)findViewById(R.id.champ);

        ArrayList<ChampionList> championLists = new ArrayList<ChampionList>();

        championLists.add(new ChampionList("84","1992/93",R.drawable.manu));
        championLists.add(new ChampionList("92","1993/94",R.drawable.manu));
        championLists.add(new ChampionList("89","1994/95",R.drawable.nck));
        championLists.add(new ChampionList("82","1995/96",R.drawable.manu));
        championLists.add(new ChampionList("75","1996/97",R.drawable.manu));
        championLists.add(new ChampionList("78","1997/98",R.drawable.ars));
        championLists.add(new ChampionList("79","1998/99",R.drawable.manu));
        championLists.add(new ChampionList("91","1999/00",R.drawable.manu));
        championLists.add(new ChampionList("80","2000/01",R.drawable.manu));
        championLists.add(new ChampionList("87","2001/02",R.drawable.ars));
        championLists.add(new ChampionList("84","2002/03",R.drawable.manu));
        championLists.add(new ChampionList("90","2003/04",R.drawable.ars));
        championLists.add(new ChampionList("95","2004/05",R.drawable.chl));
        championLists.add(new ChampionList("91","2005/06",R.drawable.chl));
        championLists.add(new ChampionList("89","2006/07",R.drawable.manu));
        championLists.add(new ChampionList("87","2007/08",R.drawable.manu));
        championLists.add(new ChampionList("90","2008/09",R.drawable.manu));
        championLists.add(new ChampionList("86","2009/10",R.drawable.chl));
        championLists.add(new ChampionList("80","2010/11",R.drawable.manu));
        championLists.add(new ChampionList("89","2011/12",R.drawable.mcity));
        championLists.add(new ChampionList("89","2012/13",R.drawable.manu));
        championLists.add(new ChampionList("86","2013/14",R.drawable.mcity));
        championLists.add(new ChampionList("87","2014/15",R.drawable.chl));
        championLists.add(new ChampionList("81","2015/16",R.drawable.lci));
        championLists.add(new ChampionList("93","2016/17",R.drawable.chl));
        championLists.add(new ChampionList("__","2017/18",R.drawable.mcity));

        ChampionAdapter championAdapter = new ChampionAdapter(this, championLists);

        listView.setAdapter(championAdapter);

    }
}
