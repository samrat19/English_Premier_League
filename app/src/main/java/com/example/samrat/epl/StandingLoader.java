package com.example.samrat.epl;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class StandingLoader extends AsyncTaskLoader<List<StandingList>> {

    private String mUrl;
    public StandingLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<StandingList> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<StandingList> standingLists = StandingQuery.fetchmoviedata(mUrl);
        return standingLists;
    }
}
