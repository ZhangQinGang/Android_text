package com.example.administrator.chunhui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.utils.StatusBarUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        initView();
        initToolbar();
    }
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        toolbar.setNavigationOnClickListener(this);
    }
    private void initView() {

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
