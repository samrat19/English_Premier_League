package com.example.samrat.epl;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StandingQuery {

    private StandingQuery() {
    }
    public static List<StandingList> fetchmoviedata(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {

        }
        List<StandingList> standingLists = extractFeatureFromJson(jsonResponse);

        return standingLists;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
        }
        return url;
    }
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {

            }
        } catch (IOException e) {

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
    private static List<StandingList> extractFeatureFromJson(String earthquakeJSON) {
        if (TextUtils.isEmpty(earthquakeJSON)) {
            return null;
        }
        List<StandingList> standingLists = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(earthquakeJSON);
            JSONArray movieArray = baseJsonResponse.getJSONArray("standing");
            for (int i = 0; i < movieArray.length(); i++) {

                JSONObject movie = movieArray.getJSONObject(i);

                String name = movie.getString("teamName");
                String point = movie.getString("position");
                String played = movie.getString("playedGames");
                String gf = movie.getString("goals");
                String ga = movie.getString("goalsAgainst");
                String gd = movie.getString("goalDifference");
                String win = movie.getString("wins");
                String loss = movie.getString("losses");
                String draw = movie.getString("draws");
                String points=movie.getString("points");
                String poster=movie.getString("crestURI");
                StandingList standingList = new StandingList(name,point,played,gf,ga,gd,win,loss,draw,points,poster);
                standingLists.add(standingList);
            }

        } catch (JSONException e) {

        }
        return standingLists;
    }
}
