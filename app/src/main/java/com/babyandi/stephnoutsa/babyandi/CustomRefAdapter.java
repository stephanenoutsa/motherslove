package com.babyandi.stephnoutsa.babyandi;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CustomRefAdapter extends ArrayAdapter<int[]> {

    public CustomRefAdapter(Context context, List<int[]> refs) {
        super(context, R.layout.custom_ref_row, refs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Resources res = getContext().getResources();
        String pkg = res.getString(R.string.package_name);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_ref_row, parent, false);

        int[] ref = getItem(position);
        ImageView refImage = (ImageView) customView.findViewById(R.id.refImage);
        TextView refLink = (TextView) customView.findViewById(R.id.refLink);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/mufferaw rg.ttf");

        refLink.setTypeface(typeface);
        int id = ref[0];
        int resID = 0;
        switch (id) {
            case 1:
                resID = res.getIdentifier(res.getString(R.string.ref_anc_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_anc_link));
                break;
            case 2:
                resID = res.getIdentifier(res.getString(R.string.ref_diarrhoea_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_diarrhoea_link));
                break;
            case 3:
                resID = res.getIdentifier(res.getString(R.string.ref_malnutrition_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_malnutrition_link));
                break;
            case 4:
                resID = res.getIdentifier(res.getString(R.string.ref_sn_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_sn_link));
                break;
            case 5:
                resID = res.getIdentifier(res.getString(R.string.ref_bfpos_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_bfpos_link));
                break;
            case 6:
                resID = res.getIdentifier(res.getString(R.string.ref_bfpos_twins_image), "drawable", pkg);
                refLink.setText(res.getString(R.string.ref_bfpos_twins_link));
                break;
        }
        refImage.setImageResource(resID);

        return customView;
    }
}
