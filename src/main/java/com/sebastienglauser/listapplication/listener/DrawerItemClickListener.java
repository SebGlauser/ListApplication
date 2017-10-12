package com.sebastienglauser.listapplication.listener;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sebastienglauser.listapplication.MainActivity;


/**
 * @Author Sebastien Glauser
 *
 * @date  28.09.2017
 *
 * @brief Drawer listener
 */

public class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {

    private final String listenerName = "DrawerItemClickListener";

    private Context context;

    /**
     * @brief   constructor
     * @param   ctx The context (used by toast)
     */
    public DrawerItemClickListener(Context ctx) {
        context = ctx;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // Print log
        Toast.makeText(context, listenerName+": "+ "onItemClick position: " + String.valueOf(position), Toast.LENGTH_SHORT).show();

        Log.d(listenerName, "onItemClick position: " + String.valueOf(position));
    }
}
