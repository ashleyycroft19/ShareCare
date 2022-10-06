package ashley.croft.sharecare;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Navigation extends AppCompatActivity {

    private WebView myWebView;
    final int MY_PERMISSION_REQUEST_LOCATION = 0;
        @SuppressLint("SetJavaScriptEnabled")

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.navigation_nearme);
            myWebView = (WebView) findViewById(R.id.webview1);
        }

    public  void initWebView(){
        WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.setWebViewClient(new WebViewClientClass());
            myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, false);
            }
        });
        myWebView.loadUrl("m.map.naver.com");
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest wrr) {
                Log.d("check URL", String.valueOf(wrr.getUrl()));
                view.loadUrl(String.valueOf(wrr.getUrl()));
                return true;
            }
        }
        public void permissionCheck() {
                  if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    initWebView();

                  } else {
                      ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
                  }
              }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == MY_PERMISSION_REQUEST_LOCATION){
            initWebView();
        }
    }

}



