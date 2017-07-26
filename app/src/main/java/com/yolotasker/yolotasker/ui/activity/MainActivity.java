package com.yolotasker.yolotasker.ui.activity;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.yolotasker.yolotasker.R;
import com.yolotasker.yolotasker.ui.AndroidApplication;
import com.yolotasker.yolotasker.ui.component.ApplicationComponent;
import com.yolotasker.yolotasker.ui.fragment.RewardFragment;
import com.yolotasker.yolotasker.ui.fragment.TaskFragment;

public class MainActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    private Drawer.Result drawerResult;

    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initDrawer();
        if(savedInstanceState == null){
            drawerResult.setSelection(1);
        }
    }

    private void initDrawer(){
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
    }

    protected ApplicationComponent getApplicationComponent() {
        AndroidApplication application = (AndroidApplication) getApplication();
        return application.getApplicationComponent();
    }
}
