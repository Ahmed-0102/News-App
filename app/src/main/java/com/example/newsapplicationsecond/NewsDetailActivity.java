package com.example.newsapplicationsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title,description,content,imageURL,url;
    private TextView titleTV, subDescTV, contentTV;
    private ImageView newsIV;
    private Button readNewsBtn;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");

        titleTV = findViewById(R.id.idTVTitle);
        subDescTV = findViewById(R.id.idTVSubDescription);
        contentTV = findViewById(R.id.idTVContent);
        readNewsBtn = findViewById(R.id.idBtnReadNews);
        newsIV = findViewById(R.id.idIVNews);

        titleTV.setText(title);
        subDescTV.setText(description);
        contentTV.setText(content);
        Picasso.with(context).load(imageURL).into(newsIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}