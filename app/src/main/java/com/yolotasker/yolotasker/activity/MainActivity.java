package com.yolotasker.yolotasker.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.fragment.RewardFragment;
import com.yolotasker.yolotasker.fragment.TaskFragment;

import butterknife.BindView;

public class MainActivity extends ActionBarActivity {

    private FrameLayout mFrameContent;
    private ListView mDrawerListView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;

    private Drawer.Result drawerResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titles = getResources().getStringArray(R.array.fragments_titles);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.tasks).withIcon(FontAwesome.Icon.faw_book).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.rewards).withIcon(FontAwesome.Icon.faw_gift).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.settings).withIcon(FontAwesome.Icon.faw_cogs).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.quit).withIcon(FontAwesome.Icon.faw_power_off).withIdentifier(4)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        switch (position){
                            case 2:
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.frame_content,new TaskFragment())
                                        .commit();
                                break;
                            case 3:
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.frame_content,new RewardFragment())
                                        .commit();
                                break;
                        }
                    }
                })
                .build();

        if(savedInstanceState == null){
            drawerResult.setSelection(2);
        }

    }
}
