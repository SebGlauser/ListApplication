package com.sebastienglauser.listapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastienglauser.listapplication.adapter.AndroidAdapter;
import com.sebastienglauser.listapplication.listener.DrawerItemClickListener;
import com.sebastienglauser.listapplication.objects.AndroidVersion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String activityName = "MainActivity";

    // Simple list requirement
    private ArrayList<String> itemsSimpleListArray = new ArrayList<String>();
    private ArrayAdapter simpleAAdapter;
    private ListView simpleListView;

    // Custom list requirement
    private ArrayList<AndroidVersion> androidList = new ArrayList<AndroidVersion>();
    private AndroidAdapter customAdapter;
    private ListView customListView;

    // Drawer requirement
    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // Simple list
        simpleListView  = (ListView) findViewById(R.id.simplelistView);
        simpleAAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsSimpleListArray);
        simpleListView.setAdapter(simpleAAdapter);
        //@debug test to add manually items on the list
        itemsSimpleListArray.add("Item1");
        itemsSimpleListArray.add("Item2");
        itemsSimpleListArray.add("Item3");

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                messageToast(item + " has been pressed");

            }

        });



        //Custom list
        customListView = (ListView) findViewById(R.id.customlistView);
        customAdapter = new AndroidAdapter(this, R.layout.custom_list_layout, androidList);
        customListView.setAdapter(customAdapter);
        //@debug test to add manually items on the list
        androidList.add(new AndroidVersion("Oreo","8.0"));
        androidList.add(new AndroidVersion("Nougat","7.x"));
        androidList.add(new AndroidVersion("Marshmallow","6.0.x"));
        androidList.add(new AndroidVersion("Lollipop","5.x"));
        androidList.add(new AndroidVersion("Kitkat","4.4.x"));

        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final AndroidVersion androidVersion = (AndroidVersion) parent.getItemAtPosition(position);
                messageToast(androidVersion.getVersionName() + " has been pressed");

            }

        });



        // Drawer
        mMenuSections = getResources().getStringArray(R.array.menu_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.left_drawer_cell, mMenuSections));

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
                mDrawerLayout, /* DrawerLayout object */
                R.string.app_name, /* "open drawer" description */
                R.string.app_name /* "close drawer" description */ ) {

            public void onDrawerClosed(View view) {
                messageToast("onDrawerClosed");
            }
            public void onDrawerOpened(View drawerView) {
                messageToast("onDrawerOpened");
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // Floating Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use a function of the activity to gain access to the class variables
                addNewItem();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id)
        {
            case R.id.action_settings:
                messageToast("onOptionsItemSelected settings has been pressed");
                break;

            case R.id.action_modify:
                messageToast("onOptionsItemSelected modify has been pressed");
                break;

            case R.id.action_add:
                messageToast("onOptionsItemSelected add has been pressed");
                break;

            default: break;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * @brief Create an AlertDialog to create an item when user quit successfully the dialog
     */
    public void addNewItem() {
        // Instantiate an alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView =
                inflater.inflate(R.layout.add_new_item_dialog, null);
        builder.setTitle("Add new item")
                .setView(dialogView);
        final TextView newItemTextField = (EditText)dialogView.findViewById(R.id.newItemEditText);

        // Add buttons and their listener
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                itemsSimpleListArray.add(String.valueOf(newItemTextField.getText()));
                simpleAAdapter.notifyDataSetChanged();

                // Inform that the item has been successfully added
                messageSnack(getResources().getString(R.string.addItemSuccesfully));

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Inform the user that the dialog has been quit by abortion ;)
                messageSnack(getResources().getString(R.string.addItemAborted));
            }
        });

        // Build and show
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void messageToast(String content) {
        Toast.makeText(this, activityName+": "+ content, Toast.LENGTH_SHORT).show();
        Log.d(activityName, content);
    }

    private void messageSnack(String content) {
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), content, Snackbar.LENGTH_SHORT)
                .show();
        Log.d(activityName, content);
    }
}
