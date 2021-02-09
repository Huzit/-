package com.example.webviewexample;

import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.naver.com";//불러올 페이지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        //웹뷰 내에서 자바스크립트가 작동되도록 설정
        webView.getSettings().setJavaScriptEnabled(true);
        //url로드
        webView.loadUrl(url);
        //크롬 브라우저로 실행
        webView.setWebChromeClient(new WebChromeClient());
        //앱 자체에서 실행
        webView.setWebViewClient(new WebViewClientClass());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //웹뷰에서 뒤로가기 버튼 쓸 수 있도록 만들어 줌
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }

        //다른 웹 클라이언트를 쓰지 않고 앱 자체에서 띄울 수 있도록 설정
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
    }
}