package com.example.dabso.test2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BeaconDetails extends Activity {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beaconlayout);
        BeaconClass getBeacon = (BeaconClass) getIntent().getSerializableExtra("Beacon");
        TextView address=(TextView) findViewById(R.id.selectedBeaconAddress);
        TextView rssi=(TextView) findViewById(R.id.selectedBeaconRssi);
        TextView distance=(TextView) findViewById(R.id.selectedBeaconDistance);

        address.setText(getBeacon.getAddress());
        rssi.setText(String.valueOf(getBeacon.getRssi()));
        distance.setText(getBeacon.distance());
    }
}
