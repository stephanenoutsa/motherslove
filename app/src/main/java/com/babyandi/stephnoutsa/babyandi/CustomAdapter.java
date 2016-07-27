package com.babyandi.stephnoutsa.babyandi;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class CustomAdapter extends ArrayAdapter<Notification> {

    public CustomAdapter(Context context, List<Notification> notifications) {
        super(context, R.layout.custom_row, notifications);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        Notification singleNotifItem = getItem(position);
        TextView notificationDate = (TextView) customView.findViewById(R.id.notificationDate);
        TextView notificationBody = (TextView) customView.findViewById(R.id.notificationBody);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/mufferaw rg.ttf");

        notificationDate.setTypeface(typeface, Typeface.BOLD);
        notificationBody.setTypeface(typeface);

        notificationDate.setText(singleNotifItem.getNday());
        notificationBody.setText(singleNotifItem.getNmessage());

        return customView;
    }
}
