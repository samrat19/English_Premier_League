package com.example.samrat.epl;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<StandingList>>{

   // private static  final String movieUrl="https://api.themoviedb.org/3/movie/now_playing?api_key=e151ccdde6fbf9ea2d84c67dfb0a920c";
 //   private static  final String movieUrl="https://api.myjson.com/bins/qitan";
    private static final String movieUrl="http://api.football-data.org/v1/competitions/445/leagueTable";
    private static final int LEAGUE_LOADER_ID = 1;
    private StandingAdapter standingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.standing);

        standingAdapter = new StandingAdapter(this, new ArrayList<StandingList>());
        listView.setAdapter(standingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),FullData.class);
                StandingList standingList = standingAdapter.getItem(position);
                String match=standingList.getPlayedgames();
                String win=standingList.getWins();
                String loss=standingList.getLosses();
                String draws=standingList.getDrwas();
                String goals=standingList.getGf();
                String ga=standingList.getGa();
                String gd=standingList.getGd();
                String pts=standingList.getPoints();
                String poster=standingList.getPoster();
                String team_name=standingList.getName();

                intent.putExtra("MATCH",match);
                intent.putExtra("WIN",win);
                intent.putExtra("LOSS",loss);
                intent.putExtra("DRAWS",draws);
                intent.putExtra("GF",goals);
                intent.putExtra("GA",ga);
                intent.putExtra("GD",gd);
                intent.putExtra("POINT",pts);
                intent.putExtra("POSTER",poster);
                intent.putExtra("TEAM_NAME",team_name);

                startActivity(intent);
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LEAGUE_LOADER_ID, null, this);
        } else {

        }
    }

    @Override
    public android.content.Loader<List<StandingList>> onCreateLoader(int id, Bundle args) {

        return new StandingLoader(this, movieUrl);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<StandingList>> loader, List<StandingList> data) {

        standingAdapter.clear();
        if (data != null && !data.isEmpty()) {
            standingAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<StandingList>> loader) {

        standingAdapter.clear();
    }
}
