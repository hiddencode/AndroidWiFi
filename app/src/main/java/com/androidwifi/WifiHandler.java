package com.androidwifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import java.util.List;


/**
 * Class for interaction with WifiManager API
 */
public class WifiHandler extends Activity {

    WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

    public void onCreate(Bundle savedState){
        super.onCreate(savedState);

        //Scan receiver handler
        BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false);
                if(success){
                    scanSuccess();
                }else{
                    scanFailure();
                }
            }
        };

        // Filter requests
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wifiScanReceiver, intentFilter);

    }

    /**
     * Method for scanning Wi-Fi points and processing them
     */
    private void scanSuccess(){
        List<ScanResult> results = wifiManager.getScanResults();

        //Processing scanning result
    }

    /**
     * Handle failure scanning
     */
    private void scanFailure(){
        //Use old scan results
    }


}
