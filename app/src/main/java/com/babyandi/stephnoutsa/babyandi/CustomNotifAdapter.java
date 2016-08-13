package com.babyandi.stephnoutsa.babyandi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

class CustomNotifAdapter extends ArrayAdapter<String> {

    public CustomNotifAdapter(Context context, List<String> stop) {
        super(context, R.layout.custom_stop_row, stop);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyDBHandler dbHandler = new MyDBHandler(getContext(), null, null, 1);
        final Resources res = getContext().getResources();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_stop_row, parent, false);

        final String stop = getItem(position);
        Button stopButton = (Button) customView.findViewById(R.id.stopButton);

        //Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/mufferaw rg.ttf");

        stopButton.setText(stop);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stop.equals(res.getString(R.string.stop_anc_notifs))) {
                    // Cancel ANC alarm
                    Intent anc = new Intent(getContext(), MyBroadcastReceiver.class);
                    PendingIntent ancIntent = PendingIntent.getBroadcast(getContext(), 0, anc, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager ancAlarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                    ancAlarm.cancel(ancIntent);

                    // Cancel hiv alarm
                    Intent hiv = new Intent(getContext(), MyBroadcastReceiver.class);
                    PendingIntent hivIntent = PendingIntent.getBroadcast(getContext(), 0, hiv, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager hivAlarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                    hivAlarm.cancel(hivIntent);

                    // Cancel hep alarm
                    Intent hep = new Intent(getContext(), MyBroadcastReceiver.class);
                    PendingIntent hepIntent = PendingIntent.getBroadcast(getContext(), 0, hep, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager hepAlarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                    hepAlarm.cancel(hepIntent);

                    // Empty LMP, HIV and HEP tables
                    dbHandler.stopAncNotifs();

                    String lmp = dbHandler.getLMP();
                    if (lmp.equals("null")) {
                        Toast.makeText(getContext(), res.getString(R.string.anc_stop_failure), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), res.getString(R.string.anc_stop_success), Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Cancel imm alarm
                    Intent imm = new Intent(getContext(), MyBroadcastReceiver.class);
                    PendingIntent immIntent = PendingIntent.getBroadcast(getContext(), 0, imm, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager immAlarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                    immAlarm.cancel(immIntent);

                    // Empty dob table
                    dbHandler.deleteDOB();

                    String dob = dbHandler.getDOB().getDday();
                    if (dob.equals("null")) {
                        Toast.makeText(getContext(), res.getString(R.string.imm_stop_failure), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), res.getString(R.string.imm_stop_success), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return customView;
    }
}
