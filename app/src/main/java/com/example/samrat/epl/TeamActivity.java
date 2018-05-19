package com.example.samrat.epl;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<TeamList>> {

    private static final String movieUrl="http://api.football-data.org/v1/competitions/445/fixtures";
    private static final int LEAGUE_LOADER_ID = 1;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


        ListView listView = (ListView)findViewById(R.id.teamPlayers);

        teamAdapter = new TeamAdapter(this, new ArrayList<TeamList>());
        listView.setAdapter(teamAdapter);


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
    public Loader<List<TeamList>> onCreateLoader(int id, Bundle args) {
        return  new TeamLoader(this,movieUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<TeamList>> loader, List<TeamList> data) {

        teamAdapter.clear();
        if (data != null && !data.isEmpty()) {
            teamAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<TeamList>> loader) {

        teamAdapter.clear();
    }
}
