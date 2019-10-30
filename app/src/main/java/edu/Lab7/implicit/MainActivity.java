package edu.Lab7.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    static ListView listView;
    static ArrayList<String> URLlist = new ArrayList<>();
    static String data = "";
    static Intent intent;
    static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();
        TextView textView = findViewById(R.id.textView);
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        listView = findViewById(R.id.listview);
        if((intent.getStringExtra(Intent.EXTRA_TEXT)) != null) {
            data = intent.getStringExtra(Intent.EXTRA_TEXT);
            URLlist.add(data);
        }
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, URLlist);

        textView.setText("Browse the web, and use the 'share' button to add the URL to this app");
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = URLlist.get(i);
                webView.loadUrl(url);
            }
        });
    }
}
