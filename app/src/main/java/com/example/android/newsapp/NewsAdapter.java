package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> implements Serializable{

    private static final String LOG_TAG = NewsLoader.class.getName();

    public NewsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
    }

    static class ListItemHolder {
        private TextView textViewSectionName, textViewWebPublicationDate, textViewWebTitle;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListItemHolder listItemHolder;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            listItemHolder = new ListItemHolder();
            listItemHolder.textViewSectionName = convertView.findViewById(R.id.textViewSectionName);
            listItemHolder.textViewWebPublicationDate = convertView.findViewById(R.id.textViewWebPublicationDate);
            listItemHolder.textViewWebTitle = convertView.findViewById(R.id.textViewWebTitle);

            convertView.setTag(listItemHolder);
        } else {
            listItemHolder = (ListItemHolder) convertView.getTag();
        }

        News currentNews = getItem(position);
        listItemHolder.textViewSectionName.setText(currentNews.getSectionName());
        listItemHolder.textViewWebPublicationDate.setText(currentNews.getWebPublicationDate());
        listItemHolder.textViewWebTitle.setText(currentNews.getWebTitle());

        return convertView;
    }
}

