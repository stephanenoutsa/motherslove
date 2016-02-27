package com.babyandi.stephnoutsa.babyandi;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] notifications) {
        super(context, R.layout.custom_row, notifications);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String singleNotifItem = getItem(position);
        TextView notificationDate = (TextView) customView.findViewById(R.id.notificationBody);
        //notificationDate.setTypeface(null, Typeface.BOLD);

        notificationDate.setText(singleNotifItem);

        return customView;
    }
}
