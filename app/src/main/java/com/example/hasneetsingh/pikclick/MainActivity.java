package com.example.hasneetsingh.pikclick;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle drawerToggleListener;
    NavigationListAdapter navigationListAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //to populate listView with string array in strings.xml
        Resources res = getResources();
        navigationListAdapter = new NavigationListAdapter(this);
        CardListFragment cardListFragment = new CardListFragment();
        android.app.FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.relative_layout,cardListFragment,"myCard");
        transaction.commit();


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("PicClick App");
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.drawer_list);
        listView.setAdapter(navigationListAdapter);
        //listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawerListItems));
        listView.setOnItemClickListener(this);
        drawerToggleListener = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


            }
        };
        drawerLayout.addDrawerListener(drawerToggleListener);
        getSupportActionBar().setHomeButtonEnabled(true);  // makes the action bar clickable
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //shows arrow which takes you to home screen
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggleListener.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Forwarding the event to navigation drawer whenever anything on the actionBar is selected
        if(drawerToggleListener.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Called whenever the screen size changes and adjust the navigation drawer size accordingly
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggleListener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectItem(i);
    }

    //Highlight the item which is selected in the navigation drawer

    public void selectItem(int position) {
        listView.setItemChecked(position,true);

    }

    //Replace the text of the title bar with the text of the item which is currently selected in the navigation drawer

    public void setTitleBarText(String title){
        getSupportActionBar().setTitle(title);
    }
}
