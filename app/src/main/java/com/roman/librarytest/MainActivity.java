package com.roman.librarytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements DownloadLibraries.Communicator{

    public static final String Library_URL = "https://data.cityofchicago.org/resource/x8fc-8rcq.json";

    ListView libraryListView;
    ProgressBar progressBar;
    TextView messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libraryListView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        messageText = (TextView) findViewById(R.id.textView);

        DownloadLibraries downloadLibs = new DownloadLibraries(this);
        downloadLibs.execute();

        libraryListView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        messageText.setVisibility(View.VISIBLE);
    }
    @Override
    public void updateProgressTo(int progress) {
        progressBar.setProgress(progress);
    }

    @Override
    public void updateUI(final ArrayList<LibraryObject> libraryArrayList) {
        libraryListView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        messageText.setVisibility(View.GONE);

        LibraryAdapter adapter = new LibraryAdapter(this, libraryArrayList);
        libraryListView.setAdapter(adapter);


        libraryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LibraryObject objectToPass = libraryArrayList.get(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("theLibObject", objectToPass);
                startActivity(intent);
            }
        });
    }
}
