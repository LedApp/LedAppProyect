package es.telefonica.talentum.ledapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import es.telefonica.talentum.ledapp.managers.MyAppWebViewClient;

public class ViewerTresDActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_tres_d);

        mWebView = (WebView)findViewById(R.id.demo_3d);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("https://skfb.ly/UWqx");

        mWebView.setWebViewClient(new WebViewClient());

        mWebView.setWebViewClient(new MyAppWebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
