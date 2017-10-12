package com.sebastienglauser.listapplication.listener;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by seg on 05.10.17.
 */

public class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {

    private final String listenerName = "DrawerItemClickListener";

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // Print log
        Log.d(listenerName, "onItemClick position: " + String.valueOf(position));
    }
}
