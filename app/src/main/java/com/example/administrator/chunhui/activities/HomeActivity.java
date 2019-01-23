package com.example.administrator.chunhui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.fragment.HomeFragment;
import com.example.administrator.chunhui.fragment.ItemsFragment;
import com.example.administrator.chunhui.fragment.KnowledgeFragment;
import com.example.administrator.chunhui.fragment.NavigationFragment;

import org.w3c.dom.Text;

import javax.xml.transform.Templates;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private HomeFragment homeFragment;
    private KnowledgeFragment knowledgeFragment;
    private NavigationFragment navigationFragment;
    private ItemsFragment itemsFragment;
    private TextView toolbar_title;
    private TextView login_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initView();
    }
    //获取RadioButton控件ID
    private void initView() {
//        login_login = findViewById(R.id.login_login);
        toolbar_title = findViewById(R.id.toolbar_title);
        RadioButton home_home = findViewById(R.id.home_home);
        RadioButton home_knowledge = findViewById(R.id.home_knowledge);
        RadioButton home_navigation = findViewById(R.id.home_navigation);
        RadioButton home_items = findViewById(R.id.home_items);
        home_home.setOnClickListener(this);
        home_knowledge.setOnClickListener(this);
        home_navigation.setOnClickListener(this);
        home_items.setOnClickListener(this);
        initDefultView();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_collect) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Setting) {
            

        } else if (id == R.id.nav_we) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_home:
                select(0);
                toolbar_title.setText("首页");
                break;
            case R.id.home_knowledge:
                select(1);
                toolbar_title.setText("知识体系");
                break;
            case R.id.home_navigation:
                select(2);
                toolbar_title.setText("导航");
                break;
            case R.id.home_items:
                select(3);
                toolbar_title.setText("项目");
                break;
//            case R.id.login_login:
//                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
//                break;
        }
    }
    private void select(int i) {
        FragmentManager fm = getSupportFragmentManager();  //获得Fragment管理器
        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

        hidtFragment(ft);   //隐藏Fragment的方法，先判断fragment是否为空，如果不为空则隐藏Fragment

        switch (i) {//点击切换fragment,如果fragment为空，则创建，如果不为空，就显示
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.fragment, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (knowledgeFragment == null) {
                    knowledgeFragment = new KnowledgeFragment();
                    ft.add(R.id.fragment, knowledgeFragment);
                } else {
                    ft.show(knowledgeFragment);
                }
                break;
            case 2:
                if (navigationFragment == null) {
                    navigationFragment = new NavigationFragment();
                    ft.add(R.id.fragment, navigationFragment);
                } else {
                    ft.show(navigationFragment);
                }
                break;
            case 3:
                if (itemsFragment == null) {
                    itemsFragment = new ItemsFragment();
                    ft.add(R.id.fragment, itemsFragment);
                } else {
                    ft.show(itemsFragment);
                }
                break;
        }
        ft.commit();   //提交事务

    }
    //隐藏所有的Fragment，在上面会用到
    private void hidtFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);

        }
        if (knowledgeFragment != null) {
            fragmentTransaction.hide(knowledgeFragment);

        }
        if (navigationFragment != null) {
            fragmentTransaction.hide(navigationFragment);

        }
        if (itemsFragment != null) {
            fragmentTransaction.hide(itemsFragment);

        }

    }
    //设置第一个页面为默认
    private void initDefultView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        homeFragment = new HomeFragment();
        ft.add(R.id.fragment, homeFragment);
        ft.commit();
    }

}
