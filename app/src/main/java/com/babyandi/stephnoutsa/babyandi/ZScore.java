package com.babyandi.stephnoutsa.babyandi;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ZScore extends AppCompatActivity {

    EditText heightInput;
    EditText weightInput;
    TextView zScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zscore);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        heightInput = (EditText) findViewById(R.id.heightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        zScore = (TextView) findViewById(R.id.zScore);
    }

    public void calculateZScore(View view) {
        double h = Double.parseDouble(heightInput.getText().toString());
        double w = Double.parseDouble(weightInput.getText().toString());
        double score;
        double meanWeight = 0;
        double standardDeviation = 0;

        if (h >= 50.0 && h < 51.0) {
            meanWeight = 3.4;
            standardDeviation = 0.400;
        }
        else if (h >= 51.0 && h < 51.5) {
            meanWeight = 3.5;
            standardDeviation = 0.400;
        }
        else if (h >= 51.5 && h < 52.0) {
            meanWeight = 3.6;
            standardDeviation = 0.430;
        }
        else if (h >= 52.0 && h < 52.5) {
            meanWeight = 3.7;
            standardDeviation = 0.450;
        }
        else if (h >= 52.5 && h < 53.0) {
            meanWeight = 3.8;
            standardDeviation = 0.460;
        }
        else if (h >= 53.0 && h < 53.5) {
            meanWeight = 3.9;
            standardDeviation = 0.480;
        }
        else if (h >= 53.5 && h < 54) {
            meanWeight = 4.0;
            standardDeviation = 0.485;
        }
        else if (h >= 54 && h < 54.5) {
            meanWeight = 4.1;
            standardDeviation = 0.500;
        }
        else if (h >= 54.5 && h < 55.0) {
            meanWeight = 4.2;
            standardDeviation = 0.500;
        }
        else if (h >= 55.0 && h < 55.5) {
            meanWeight = 4.3;
            standardDeviation = 0.515;
        }
        else if (h >= 55.5 && h < 56.0) {
            meanWeight = 4.4;
            standardDeviation = 0.520;
        }
        else if (h >= 56.0 && h < 56.5) {
            meanWeight = 4.6;
            standardDeviation = 0.550;
        }
        else if (h >= 56.5 && h < 57.0) {
            meanWeight = 4.7;
            standardDeviation = 0.555;
        }
        else if (h >= 57.0 && h < 57.5) {
            meanWeight = 4.8;
            standardDeviation = 0.565;
        }
        else if (h >= 57.5 && h < 58.0) {
            meanWeight = 4.9;
            standardDeviation = 0.570;
        }
        else if (h >= 58.0 && h < 58.5) {
            meanWeight = 5.1;
            standardDeviation = 0.600;
        }
        else if (h >= 58.5 && h < 59.0) {
            meanWeight = 5.2;
            standardDeviation = 0.600;
        }
        else if (h >= 59.0 && h < 59.5) {
            meanWeight = 5.3;
            standardDeviation = 0.600;
        }
        else if (h >= 59.5 && h < 60.0) {
            meanWeight = 5.5;
            standardDeviation = 0.630;
        }
        else if (h >= 60.0 && h < 60.5) {
            meanWeight = 5.6;
            standardDeviation = 0.630;
        }
        else if (h >= 60.5 && h < 61.0) {
            meanWeight = 5.7;
            standardDeviation = 0.625;
        }
        else if (h >= 61.0 && h < 61.5) {
            meanWeight = 5.9;
            standardDeviation = 0.660;
        }
        else if (h >= 61.5 && h < 62.0) {
            meanWeight = 6.0;
            standardDeviation = 0.650;
        }
        else if (h >= 62.0 && h < 62.5) {
            meanWeight = 6.2;
            standardDeviation = 0.680;
        }
        else if (h >= 62.5 && h < 63.0) {
            meanWeight = 6.3;
            standardDeviation = 0.675;
        }
        else if (h >= 63.0 && h < 63.5) {
            meanWeight = 6.5;
            standardDeviation = 0.700;
        }
        else if (h >= 63.5 && h < 64.0) {
            meanWeight = 6.6;
            standardDeviation = 0.685;
        }
        else if (h >= 64.0 && h < 64.5) {
            meanWeight = 6.7;
            standardDeviation = 0.675;
        }
        else if (h >= 64.5 && h < 65.0) {
            meanWeight = 6.9;
            standardDeviation = 0.700;
        }
        else if (h >= 65.0 && h < 65.5) {
            meanWeight = 7.0;
            standardDeviation = 0.700;
        }
        else if (h >= 65.5 && h < 66.0) {
            meanWeight = 7.2;
            standardDeviation = 0.725;
        }
        else if (h >= 66.0 && h < 66.5) {
            meanWeight = 7.3;
            standardDeviation = 0.715;
        }
        else if (h >= 66.5 && h < 67.0) {
            meanWeight = 7.5;
            standardDeviation = 0.730;
        }
        else if (h >= 67.0 && h < 67.5) {
            meanWeight = 7.6;
            standardDeviation = 0.730;
        }
        else if (h >= 67.5 && h < 68.0) {
            meanWeight = 7.8;
            standardDeviation = 0.760;
        }
        else if (h >= 68.0 && h < 68.5) {
            meanWeight = 7.9;
            standardDeviation = 0.750;
        }
        else if (h >= 68.5 && h < 69.0) {
            meanWeight = 8.0;
            standardDeviation = 0.750;
        }
        else if (h >= 69.0 && h < 69.5) {
            meanWeight = 8.2;
            standardDeviation = 0.770;
        }
        else if (h >= 69.5 && h < 70.0) {
            meanWeight = 8.3;
            standardDeviation = 0.760;
        }
        else if (h >= 70.0 && h < 70.5) {
            meanWeight = 8.5;
            standardDeviation = 0.785;
        }
        else if (h >= 70.5 && h < 71.0) {
            meanWeight = 8.6;
            standardDeviation = 0.780;
        }
        else if (h >= 71.0 && h < 71.5) {
            meanWeight = 8.7;
            standardDeviation = 0.770;
        }
        else if (h >= 71.5 && h < 72.0) {
            meanWeight = 8.9;
            standardDeviation = 0.800;
        }
        else if (h >= 72.0 && h < 72.5) {
            meanWeight = 9.0;
            standardDeviation = 0.800;
        }
        else if (h >= 72.5 && h < 73.0) {
            meanWeight = 9.1;
            standardDeviation = 0.800;
        }
        else if (h >= 73.0 && h < 73.5) {
            meanWeight = 9.2;
            standardDeviation = 0.800;
        }
        else if (h >= 73.5 && h < 74.0) {
            meanWeight = 9.4;
            standardDeviation = 0.830;
        }
        else if (h >= 74.0 && h < 74.5) {
            meanWeight = 9.5;
            standardDeviation = 0.830;
        }
        else if (h >= 74.5 && h < 75.0) {
            meanWeight = 9.6;
            standardDeviation = 0.830;
        }
        else if (h >= 75.0 && h < 75.5) {
            meanWeight = 9.7;
            standardDeviation = 0.825;
        }
        else if (h >= 75.5 && h < 76.0) {
            meanWeight = 9.8;
            standardDeviation = 0.825;
        }
        else if (h >= 76.0 && h < 76.5) {
            meanWeight = 9.9;
            standardDeviation = 0.825;
        }
        else if (h >= 76.5 && h < 77.0) {
            meanWeight = 10.0;
            standardDeviation = 0.825;
        }
        else if (h >= 77.0 && h < 77.5) {
            meanWeight = 10.1;
            standardDeviation = 0.825;
        }
        else if (h >= 77.5 && h < 78.0) {
            meanWeight = 10.2;
            standardDeviation = 0.825;
        }
        else if (h >= 78.0 && h < 78.5) {
            meanWeight = 10.4;
            standardDeviation = 0.880;
        }
        else if (h >= 78.5 && h < 79.0) {
            meanWeight = 10.5;
            standardDeviation = 0.880;
        }
        else if (h >= 79.0 && h < 79.5) {
            meanWeight = 10.6;
            standardDeviation = 0.880;
        }
        else if (h >= 79.5 && h < 80.0) {
            meanWeight = 10.7;
            standardDeviation = 0.880;
        }
        else if (h >= 80.0 && h < 80.5) {
            meanWeight = 10.8;
            standardDeviation = 0.885;
        }
        else if (h >= 80.5 && h < 81.0) {
            meanWeight = 10.9;
            standardDeviation = 0.885;
        }
        else if (h >= 81.0 && h < 81.5) {
            meanWeight = 11.0;
            standardDeviation = 0.900;
        }
        else if (h >= 81.5 && h < 82.0) {
            meanWeight = 11.1;
            standardDeviation = 0.900;
        }
        else if (h >= 82.0 && h < 82.5) {
            meanWeight = 11.2;
            standardDeviation = 0.900;
        }
        else if (h >= 82.5 && h < 83.0) {
            meanWeight = 11.3;
            standardDeviation = 0.900;
        }
        else if (h >= 83.0 && h < 83.5) {
            meanWeight = 11.4;
            standardDeviation = 0.900;
        }
        else if (h >= 83.5 && h < 84.0) {
            meanWeight = 11.5;
            standardDeviation = 0.925;
        }
        else if (h >= 84.0 && h < 84.5) {
            meanWeight = 11.5;
            standardDeviation = 0.900;
        }
        else if (h >= 84.5 && h < 85.0) {
            meanWeight = 11.6;
            standardDeviation = 0.900;
        }
        else if (h >= 85.0 && h < 85.5) {
            meanWeight = 12.0;
            standardDeviation = 1.080;
        }
        else if (h >= 85.5 && h < 86.0) {
            meanWeight = 12.1;
            standardDeviation = 1.100;
        }
        else if (h >= 86.0 && h < 86.5) {
            meanWeight = 12.2;
            standardDeviation = 1.100;
        }
        else if (h >= 86.5 && h < 87.0) {
            meanWeight = 12.3;
            standardDeviation = 1.100;
        }
        else if (h >= 87.0 && h < 87.5) {
            meanWeight = 12.4;
            standardDeviation = 1.100;
        }
        else if (h >= 87.5 && h < 88.0) {
            meanWeight = 12.5;
            standardDeviation = 1.100;
        }
        else if (h >= 88.0 && h < 88.5) {
            meanWeight = 12.6;
            standardDeviation = 1.100;
        }
        else if (h >= 88.5 && h < 89.0) {
            meanWeight = 12.8;
            standardDeviation = 1.150;
        }
        else if (h >= 89.0 && h < 89.5) {
            meanWeight = 12.9;
            standardDeviation = 1.150;
        }
        else if (h >= 89.5 && h < 90.0) {
            meanWeight = 13.0;
            standardDeviation = 1.150;
        }
        else if (h >= 90.0 && h < 90.5) {
            meanWeight = 13.1;
            standardDeviation = 1.160;
        }
        else if (h >= 90.5 && h < 91.0) {
            meanWeight = 13.2;
            standardDeviation = 1.160;
        }
        else if (h >= 91.0 && h < 91.5) {
            meanWeight = 13.3;
            standardDeviation = 1.175;
        }
        else if (h >= 91.5 && h < 92.0) {
            meanWeight = 13.4;
            standardDeviation = 1.170;
        }
        else if (h >= 92.0 && h < 92.5) {
            meanWeight = 13.6;
            standardDeviation = 1.200;
        }
        else if (h >= 92.5 && h < 93.0) {
            meanWeight = 13.7;
            standardDeviation = 1.200;
        }
        else if (h >= 93.0 && h < 93.5) {
            meanWeight = 13.8;
            standardDeviation = 1.200;
        }
        else if (h >= 93.5 && h < 94.0) {
            meanWeight = 13.9;
            standardDeviation = 1.215;
        }
        else if (h >= 94.0 && h < 94.5) {
            meanWeight = 14.0;
            standardDeviation = 1.215;
        }
        else if (h >= 94.5 && h < 95.0) {
            meanWeight = 14.2;
            standardDeviation = 1.260;
        }
        else if (h >= 95.0 && h < 95.5) {
            meanWeight = 14.3;
            standardDeviation = 1.260;
        }
        else if (h >= 95.5 && h < 96.0) {
            meanWeight = 14.4;
            standardDeviation = 1.260;
        }
        else if (h >= 96.0 && h < 96.5) {
            meanWeight = 14.5;
            standardDeviation = 1.275;
        }
        else if (h >= 96.5 && h < 97.0) {
            meanWeight = 14.7;
            standardDeviation = 1.300;
        }
        else if (h >= 97.0 && h < 97.5) {
            meanWeight = 14.8;
            standardDeviation = 1.300;
        }
        else if (h >= 97.5 && h < 98.0) {
            meanWeight = 14.9;
            standardDeviation = 1.300;
        }
        else if (h >= 98.0 && h < 98.5) {
            meanWeight = 15.0;
            standardDeviation = 1.300;
        }
        else if (h >= 98.5 && h < 99.0) {
            meanWeight = 15.2;
            standardDeviation = 1.350;
        }
        else if (h >= 99.0 && h < 99.5) {
            meanWeight = 15.3;
            standardDeviation = 1.350;
        }
        else if (h >= 99.5 && h < 100.0) {
            meanWeight = 15.4;
            standardDeviation = 1.350;
        }
        else if (h >= 100.0 && h < 100.5) {
            meanWeight = 15.6;
            standardDeviation = 1.380;
        }
        else if (h >= 100.5 && h < 101.0) {
            meanWeight = 15.7;
            standardDeviation = 1.380;
        }
        else if (h >= 101.0 && h < 101.5) {
            meanWeight = 15.8;
            standardDeviation = 1.380;
        }
        else if (h >= 101.5 && h < 102.0) {
            meanWeight = 16.0;
            standardDeviation = 1.400;
        }
        else if (h >= 102.0 && h < 102.5) {
            meanWeight = 16.1;
            standardDeviation = 1.415;
        }
        else if (h >= 102.5 && h < 103.0) {
            meanWeight = 16.2;
            standardDeviation = 1.415;
        }
        else if (h >= 103.0 && h < 103.5) {
            meanWeight = 16.4;
            standardDeviation = 1.440;
        }
        else if (h >= 103.5 && h < 104.0) {
            meanWeight = 16.5;
            standardDeviation = 1.450;
        }
        else if (h >= 104.0 && h < 104.5) {
            meanWeight = 16.7;
            standardDeviation = 1.480;
        }
        else if (h >= 104.5 && h < 105.0) {
            meanWeight = 16.8;
            standardDeviation = 1.480;
        }
        else if (h >= 105.0 && h < 105.5) {
            meanWeight = 16.9;
            standardDeviation = 1.475;
        }
        else if (h >= 105.5 && h < 106.0) {
            meanWeight = 17.1;
            standardDeviation = 1.500;
        }
        else if (h >= 106.0 && h < 106.5) {
            meanWeight = 17.2;
            standardDeviation = 1.500;
        }
        else if (h >= 106.5 && h < 107.0) {
            meanWeight = 17.4;
            standardDeviation = 1.530;
        }
        else if (h >= 107.0 && h < 107.5) {
            meanWeight = 17.5;
            standardDeviation = 1.525;
        }
        else if (h >= 107.5 && h < 108.0) {
            meanWeight = 17.7;
            standardDeviation = 1.560;
        }
        else if (h >= 108.0 && h < 108.5) {
            meanWeight = 17.8;
            standardDeviation = 1.550;
        }
        else if (h >= 108.5 && h < 109.0) {
            meanWeight = 18.0;
            standardDeviation = 1.580;
        }
        else if (h >= 109.0 && h < 109.5) {
            meanWeight = 18.1;
            standardDeviation = 1.575;
        }
        else if (h >= 109.5 && h < 110.0) {
            meanWeight = 18.3;
            standardDeviation = 1.600;
        }
        else if (h >= 110.0 && h < 110.5) {
            meanWeight = 18.4;
            standardDeviation = 1.600;
        }
        else if (h >= 110.5 && h < 111.0) {
            meanWeight = 18.6;
            standardDeviation = 1.600;
        }
        else if (h >= 111.0 && h < 111.5) {
            meanWeight = 18.8;
            standardDeviation = 1.630;
        }
        else if (h >= 111.5 && h < 112.0) {
            meanWeight = 18.9;
            standardDeviation = 1.625;
        }
        else if (h >= 112.0 && h < 112.5) {
            meanWeight = 19.1;
            standardDeviation = 1.650;
        }
        else if (h >= 112.5 && h < 113.0) {
            meanWeight = 19.3;
            standardDeviation = 1.680;
        }
        else if (h >= 113.0 && h < 113.5) {
            meanWeight = 19.4;
            standardDeviation = 1.660;
        }
        else if (h >= 113.5 && h < 114.0) {
            meanWeight = 19.6;
            standardDeviation = 1.680;
        }
        else if (h >= 114.0 && h < 114.5) {
            meanWeight = 19.8;
            standardDeviation = 1.700;
        }
        else if (h >= 114.5 && h < 115.0) {
            meanWeight = 19.9;
            standardDeviation = 1.700;
        }
        else if (h >= 115.0 && h < 115.5) {
            meanWeight = 20.1;
            standardDeviation = 1.700;
        }
        else if (h >= 115.5 && h < 116.0) {
            meanWeight = 20.3;
            standardDeviation = 1.730;
        }
        else if (h >= 116.0 && h < 116.5) {
            meanWeight = 20.5;
            standardDeviation = 1.750;
        }
        else if (h >= 116.5 && h < 117.0) {
            meanWeight = 20.7;
            standardDeviation = 1.760;
        }
        else if (h >= 117.0 && h < 117.5) {
            meanWeight = 20.8;
            standardDeviation = 1.760;
        }
        else if (h >= 117.5 && h < 118.0) {
            meanWeight = 21.0;
            standardDeviation = 1.775;
        }
        else if (h >= 118.0 && h < 118.5) {
            meanWeight = 21.2;
            standardDeviation = 1.785;
        }
        else if (h >= 118.5 && h < 119.0) {
            meanWeight = 21.4;
            standardDeviation = 1.800;
        }
        else if (h >= 119.0 && h < 119.5) {
            meanWeight = 21.6;
            standardDeviation = 1.815;
        }
        else if (h >= 119.5 && h < 120.0) {
            meanWeight = 21.8;
            standardDeviation = 1.830;
        }
        else if (h >= 120.0 && h < 120.5) {
            meanWeight = 22.0;
            standardDeviation = 1.850;
        }
        else if (h >= 120.5 && h < 121.0) {
            meanWeight = 22.2;
            standardDeviation = 1.860;
        }
        else if (h >= 121.0 && h < 121.5) {
            meanWeight = 22.4;
            standardDeviation = 1.875;
        }
        else if (h >= 121.5 && h < 122.0) {
            meanWeight = 22.6;
            standardDeviation = 1.900;
        }
        else if (h >= 122.0 && h < 122.5) {
            meanWeight = 22.8;
            standardDeviation = 1.900;
        }
        else if (h >= 122.5 && h < 123.0) {
            meanWeight = 23.1;
            standardDeviation = 1.950;
        }
        else if (h >= 123.0 && h < 123.5) {
            meanWeight = 23.3;
            standardDeviation = 1.960;
        }
        else if (h >= 123.5 && h < 124.0) {
            meanWeight = 23.5;
            standardDeviation = 1.975;
        }
        else if (h >= 124.0 && h < 124.5) {
            meanWeight = 23.7;
            standardDeviation = 2.000;
        }
        else if (h >= 124.5 && h < 125.0) {
            meanWeight = 24.0;
            standardDeviation = 2.030;
        }
        else if (h >= 125.0 && h < 125.5) {
            meanWeight = 24.2;
            standardDeviation = 2.050;
        }
        else if (h >= 125.5 && h < 126.0) {
            meanWeight = 24.4;
            standardDeviation = 2.060;
        }
        else if (h >= 126.0 && h < 126.5) {
            meanWeight = 24.7;
            standardDeviation = 2.100;
        }
        else if (h >= 126.5 && h < 127.0) {
            meanWeight = 24.9;
            standardDeviation = 2.115;
        }
        else if (h >= 127.0 && h < 127.5) {
            meanWeight = 25.2;
            standardDeviation = 2.155;
        }
        else if (h >= 127.5 && h < 128.0) {
            meanWeight = 25.4;
            standardDeviation = 2.175;
        }
        else if (h >= 128.0 && h < 128.5) {
            meanWeight = 25.7;
            standardDeviation = 2.200;
        }
        else if (h >= 128.5 && h < 129.0) {
            meanWeight = 26.0;
            standardDeviation = 2.260;
        }
        else if (h >= 129.0 && h < 129.5) {
            meanWeight = 26.2;
            standardDeviation = 2.275;
        }
        else if (h >= 129.5 && h < 130.0) {
            meanWeight = 26.5;
            standardDeviation = 2.300;
        }
        else if (h >= 130.0 && h < 130.5) {
            meanWeight = 26.8;
            standardDeviation = 2.360;
        }
        else if (h >= 130.5 && h < 131.0) {
            meanWeight = 27.1;
            standardDeviation = 2.400;
        }
        else if (h >= 131.0 && h < 131.5) {
            meanWeight = 27.4;
            standardDeviation = 2.450;
        }
        else if (h >= 131.5 && h < 132.0) {
            meanWeight = 27.6;
            standardDeviation = 2.460;
        }
        else if (h >= 132.0 && h < 132.5) {
            meanWeight = 27.9;
            standardDeviation = 2.500;
        }
        else if (h >= 132.5 && h < 133.0) {
            meanWeight = 28.2;
            standardDeviation = 2.550;
        }
        else if (h >= 133.0 && h < 133.5) {
            meanWeight = 28.6;
            standardDeviation = 2.630;
        }
        else if (h >= 133.5 && h < 134.0) {
            meanWeight = 28.9;
            standardDeviation = 2.660;
        }
        else if (h >= 134.0 && h < 134.5) {
            meanWeight = 29.2;
            standardDeviation = 2.700;
        }
        else if (h >= 134.5 && h < 135.0) {
            meanWeight = 29.5;
            standardDeviation = 2.760;
        }
        else if (h >= 135.0 && h < 135.5) {
            meanWeight = 29.8;
            standardDeviation = 2.800;
        }
        else if (h >= 135.5 && h < 136.0) {
            meanWeight = 30.2;
            standardDeviation = 2.880;
        }
        else if (h >= 136.0 && h < 136.5) {
            meanWeight = 30.5;
            standardDeviation = 2.925;
        }
        else if (h >= 136.5 && h < 137.0) {
            meanWeight = 30.9;
            standardDeviation = 3.000;
        }
        else if (h >= 137.0 && h < 137.5) {
            meanWeight = 31.2;
            standardDeviation = 3.050;
        }

        score = (w - meanWeight) / standardDeviation;

        if (h < 50 || h >= 137.5){
            zScore.setText(R.string.zscore_out_of_bounds);
        }
        else {
            if (score >= -1 && score <= -2) {
                zScore.setText(R.string.zscore_announcer);
                zScore.append(" " + new DecimalFormat("##.##").format(score) + "\n");
                zScore.append(getResources().getString(R.string.zscore_normal));
            }
            else {
                zScore.setText(R.string.zscore_announcer);
                zScore.append(" " + new DecimalFormat("##.##").format(score) + "\n");
                zScore.append(getResources().getString(R.string.zscore_malnourished));
            }
        }
    }

    ////////////Intents for menu items////////////
    public void onClickAnc() {
        Intent i = new Intent(this, ANC.class);
        startActivity(i);
    }

    public void onClickMalnutrition() {
        Intent i = new Intent(this, Malnutrition.class);
        startActivity(i);
    }

    public void onClickDiarrhoea() {
        Intent i = new Intent(this, Diarrhoea.class);
        startActivity(i);
    }

    public void onClickSpecialNeeds() {
        Intent i = new Intent(this, SpecialNeeds.class);
        startActivity(i);
    }
    ////////////////End of Intents/////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.search) {
            onSearchRequested();
            return true;
        }*/
        if (id == R.id.notifications) {
            Intent i = new Intent(this, Notifications.class);
            startActivity(i);
        }
        if (id == R.id.about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }
        if (id == R.id.go_to_anc) {
            onClickAnc();
            return true;
        }
        if (id == R.id.go_to_malnutrition) {
            onClickMalnutrition();
            return true;
        }
        if (id == R.id.go_to_diarrhoea) {
            onClickDiarrhoea();
            return true;
        }
        if (id == R.id.go_to_special_needs) {
            onClickSpecialNeeds();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
