package com.example.samrat.epl;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class TeamLoader extends AsyncTaskLoader<List<TeamList>> {

    private String mUrl;
    public TeamLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<TeamList> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<TeamList> teamLists = TeamQuery.fetchmoviedata(mUrl);
        return teamLists;
    }
}
