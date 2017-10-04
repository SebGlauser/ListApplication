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


    public AndroidAdapter(Context context, int textViewResourceId,
                          ArrayList<AndroidVersion> versions) {
        super(context, textViewResourceId, versions);
        this.androidVersionList = versions;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        final AndroidVersion androidVersion = androidVersionList.get(position);
        if (androidVersion != null) {
            final TextView title
                    = (TextView) view.findViewById(R.id.custom_list_layout_title);
            final TextView description
                    = (TextView) view.findViewById(R.id.custom_list_layout_description);
            final String versionName =  res.getString(R.string.custom_list_title)
                    + " " + androidVersion.getVersionName();
            title.setText(versionName);
            final String versionNumber = res.getString(R.string.custom_list_desc).toString()
                    + " " + androidVersion.getVersionNumber();
            description.setText(versionNumber);
        }
        return view;
    }
}
