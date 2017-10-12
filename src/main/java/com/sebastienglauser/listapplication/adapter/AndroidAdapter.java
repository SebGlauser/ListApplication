package com.sebastienglauser.listapplication.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sebastienglauser.listapplication.R;
import com.sebastienglauser.listapplication.objects.AndroidVersion;

import java.util.ArrayList;

/**
 * @Author Sebastien Glauser
 *
 * @date  28.09.2017
 *
 * @brief Adapter that contain the android version
 */
public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    private ArrayList<AndroidVersion> androidVersionList;
    private Context context;
    private int viewRes;
    private Resources res;

    /**
     * @brief   constructor
     * @param   context the name of version of the android.
     * @param   textViewResourceId  the number of the version of the android.
     */
    public AndroidAdapter(Context context, int textViewResourceId,
                          ArrayList<AndroidVersion> versions) {
        super(context, textViewResourceId, versions);
        this.androidVersionList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }


    /**
     * @brief getView extends of the ArrayAdapter
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        // inflate layout
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }

        // Get the android version with the position
        final AndroidVersion androidVersion = androidVersionList.get(position);

        // Fill the view
        if (androidVersion != null) {
            // Get objects from the layout
            final TextView title
                    = (TextView) view.findViewById(R.id.custom_list_layout_title);
            final TextView description
                    = (TextView) view.findViewById(R.id.custom_list_layout_description);


            // Set objects value
            description.setText(res.getString(R.string.custom_list_title)
                    + " "
                    + androidVersion.getVersionName());

            title.setText(res.getString(R.string.custom_list_desc)
                    + " "
                    + androidVersion.getVersionNumber());
        }

        // This methode return the view.
        return view;
    }
}
