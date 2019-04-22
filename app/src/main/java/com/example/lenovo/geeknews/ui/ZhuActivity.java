package com.example.lenovo.geeknews.ui;


//李旭阳

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.weixin.SearchBean;
import com.example.lenovo.geeknews.ui.about.fragment.AboutFragment;
import com.example.lenovo.geeknews.ui.collect.fragment.CollectFragment;
import com.example.lenovo.geeknews.ui.gank.fragment.GankFragment;
import com.example.lenovo.geeknews.ui.gold.fragment.GoldFragment;
import com.example.lenovo.geeknews.ui.setting.fragment.SettingFragment;
import com.example.lenovo.geeknews.ui.v2ex.fragment.V2exFragment;
import com.example.lenovo.geeknews.ui.weixin.fragment.WeatChFragment;
import com.example.lenovo.geeknews.ui.zhihu.fragment.ZhihuFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDl;
    @BindView(R.id.tool_fragment)
    FrameLayout toolFragment;
    @BindView(R.id.searchView)
    MaterialSearchView mSearchView;
    private ZhihuFragment zhihuFragment;
    private WeatChFragment weatChFragment;
    private GankFragment gankFragment;
    private GoldFragment goldFragment;
    private V2exFragment v2exFragment;
    private CollectFragment collectFragment;
    private SettingFragment settingFragment;
    private AboutFragment aboutFragment;
    private MenuItem itemMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);

        /*mSearchView.setOnQueryTextListener(this);
        mSearchView.setOnSearchViewListener(this);*/
        //toolBar
        mToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolBar);
        //旋转开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolBar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDl.addDrawerListener(toggle);
        toggle.syncState();
        nv.setNavigationItemSelectedListener(this);
        zhihuFragment = new ZhihuFragment();
        weatChFragment = new WeatChFragment();
        gankFragment = new GankFragment();
        goldFragment = new GoldFragment();
        v2exFragment = new V2exFragment();
        collectFragment = new CollectFragment();
        settingFragment = new SettingFragment();
        aboutFragment = new AboutFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, zhihuFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.in || itemId == R.id.cho) {
            return false;
        }
        if (itemId==R.id.wechat||itemId==R.id.gank){
            itemMenu.setVisible(true);
        }else{
            itemMenu.setVisible(false);
        }
        item.setChecked(true);
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (id == R.id.zhihu) {
            mToolBar.setTitle("知乎日报");
            transaction.replace(R.id.fragment_container, zhihuFragment).commit();
        } else if (id == R.id.wechat) {
            mToolBar.setTitle("微信精选");
            transaction.replace(R.id.fragment_container, weatChFragment).commit();
        } else if (id == R.id.gank) {
            mToolBar.setTitle("干货集中营");
            transaction.replace(R.id.fragment_container, gankFragment).commit();
        } else if (id == R.id.gold) {
            mToolBar.setTitle("稀士掘金");
            transaction.replace(R.id.fragment_container, goldFragment).commit();
        } else if (id == R.id.v2ex) {
            mToolBar.setTitle("V2EX");
            transaction.replace(R.id.fragment_container, v2exFragment).commit();
        } else if (id == R.id.collect) {
            mToolBar.setTitle("收藏");
            transaction.replace(R.id.fragment_container, collectFragment).commit();
        } else if (id == R.id.settings) {
            mToolBar.setTitle("设置");
            transaction.replace(R.id.fragment_container, settingFragment).commit();
        } else if (id == R.id.about) {
            mToolBar.setTitle("关于");
            transaction.replace(R.id.fragment_container, aboutFragment).commit();
        }
        mDl.closeDrawer(GravityCompat.START);
        return true;
    } @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        itemMenu = menu.findItem(R.id.action_search);
        //隐藏menu,搜索框就不见了,想要搜索框不见只能使用mSearchViewItem
        itemMenu.setVisible(false);
        mSearchView.setMenuItem(itemMenu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确定退出GeekNews吗?")
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SearchBean bean = new SearchBean();
                bean.setSearch(newText);
                EventBus.getDefault().postSticky(bean);
                return false;
            }
        });
        return super.dispatchTouchEvent(ev);
    }
}
