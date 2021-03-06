package com.yolotasker.yolotasker.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
import com.yolotasker.yolotasker.ui.utils.HasComponent;

public class MainActivity extends ActionBarActivity implements HasComponent<ApplicationComponent> {

    protected Toolbar mToolbar;
    protected Drawer.Result drawerResult;
    protected ApplicationComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initDrawer();
        if(savedInstanceState == null){
            drawerResult.setSelection(0);
        }
        AndroidApplication application = (AndroidApplication) getApplication();
        appComponent = application.getApplicationComponent();
    }

    protected void initDrawer(){
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
                               /* getFragmentManager().beginTransaction()
                                        .replace(R.id.frame_content,new TaskInProgressFragment())
                                        .commit();*/
                               startActivity(new Intent(getApplicationContext(), TaskActivity.class));
                                break;
                            case 3:
                              /*  getFragmentManager().beginTransaction()
                                        .replace(R.id.frame_content,new RewardFragment())
                                        .commit();*/
                                startActivity(new Intent(getApplicationContext(), RewardActivity.class));
                                break;
                        }
                    }
                })
                .build();
    }

    @Override
    public ApplicationComponent getComponent() {
        return appComponent;
    }
}
