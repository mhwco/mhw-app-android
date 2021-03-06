package org.mhwco.mhw;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String home_url = "https://mhw-app-web.mhwco.org/";
    private String feedback_email = "crs_16423@outlook.com";
    long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "测试版应用 ver0.0.1_pre", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        WebView webView = (WebView)findViewById(R.id.wv);
        WebSettings settings = webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDefaultTextEncodingName("utf-8");
        webView.setWebViewClient(new WebViewClient(){
            //ProgressDialog prd = new ProgressDialog(getApplicationContext());
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv,String url){
                wv.loadUrl(url);
                return true;
            }
            @Override
            public void onPageStarted(WebView wv, String url, Bitmap favico){
                Toast.makeText(getApplicationContext(),url+"开始加载",Toast.LENGTH_SHORT).show();
                /*prd.setMessage("请稍候");
                prd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                prd.show();*/
            }
            @Override
            public void onReceivedError(WebView wv, int errorCode, String description,
                                        String failingUrl){
                //new AlertDialog.Builder(getApplicationContext()).setTitle("Oops!").setMessage("网页遇到一些小错误...\n错误码:" + errorCode + "\n错误描述:" + description + "\n错误出现在:" + failingUrl).setPositiveButton("确定",null).create().show();
                Toast.makeText(getApplicationContext(),"网页遇到一些小错误...\n错误码:" + errorCode + "\n错误描述:" + description + "\n错误出现在:" + failingUrl,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onPageFinished(WebView wv,String url){
                Toast.makeText(getApplicationContext(),url+"加载完成",Toast.LENGTH_SHORT).show();
                //prd.dismiss();
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){

        });
        webView.loadUrl(home_url+"index.html");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        WebView webView = (WebView) findViewById(R.id.wv);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (webView.canGoBack()) {
        webView.goBack();
        } else if ((System.currentTimeMillis() - exitTime) > 2000) {
        Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
        exitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_daily) {

        } else if (id == R.id.nav_article) {

        } else if (id == R.id.nav_github) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
