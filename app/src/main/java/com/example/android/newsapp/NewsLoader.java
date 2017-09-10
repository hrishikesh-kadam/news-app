package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.SearchView;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>>{

    private static final String LOG_TAG = NewsLoader.class.getName();
    private SearchView searchView;

    public NewsLoader(Context context, SearchView searchView) {
        super(context);
        Log.v(LOG_TAG, "-> NewsLoader");
        this.searchView = searchView;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "-> onStartLoading");
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        Log.v(LOG_TAG, "-> loadInBackground");
        String searchQuery = searchView.getQuery().toString();

        if( searchQuery.isEmpty() )
            return null;
        else {
            String newsBaseUrl = getContext().getResources().getString(R.string.baseUrl);

            Uri baseUri = Uri.parse(getContext().getResources().getString(R.string.baseUrl));
            Uri.Builder builder = baseUri.buildUpon();
            builder.appendQueryParameter("q", searchQuery);
            builder.appendQueryParameter("api-key", "test");

            List<News> newsList = QueryUtils.fetchNewsQuery(builder.toString());
            return newsList;
        }
    }
}
