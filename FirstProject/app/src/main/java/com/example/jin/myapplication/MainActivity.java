package com.example.jin.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHostSetup();
        ListViewSetup();
    }

    protected void TabHostSetup()
    {
        TabHost th = (TabHost)findViewById(R.id.tabHost);
        th.setup();

        TabSpec ts1 = th.newTabSpec("Tab1").setContent(R.id.tab1).setIndicator(getString(R.string.tab1));
        TabSpec ts2 = th.newTabSpec("Tab2").setContent(R.id.tab2).setIndicator(getString(R.string.tab3));
        TabSpec ts3 = th.newTabSpec("Tab2").setContent(R.id.tab2).setIndicator(getString(R.string.tab3));
        th.addTab(ts1);
        th.addTab(ts2);
        th.addTab(ts3);

        th.getTabWidget().getChildAt(0).getLayoutParams().height = 80;
        th.getTabWidget().getChildAt(1).getLayoutParams().height = 80;
        th.getTabWidget().getChildAt(2).getLayoutParams().height = 80;
    }

    private void ListViewSetup()
    {
        ListView LV = (ListView)findViewById(R.id.listView);
        String[] values = new String[] { "Android",
                "iPhone",
                "WindowsMobile",
                "Blackberry",
                "WebOS",
                "Ubuntu",
                "Windows7",
                "Max OS X"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        LV.setAdapter(adapter);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
