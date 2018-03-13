package com.example.kechuanqi.shareelement;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;

import com.example.kechuanqi.shareelement.adapter.ImageAdater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageAdater imageAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //固定RecyclerView的大小
        recyclerView.setHasFixedSize(true);
        imageAdater = new ImageAdater(this);
        recyclerView.setAdapter(imageAdater);


        String[] urls = new String[]{"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=310285538,3913600831&fm=27&gp=0.jpg"
        ,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3954174014,32179589&fm=27&gp=0.jpg"
        ,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=885700797,813100070&fm=27&gp=0.jpg"
        ,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4137982776,111672785&fm=27&gp=0.jpg"
        ,"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3347193067,1374184117&fm=11&gp=0.jpg"
        ,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=637336631,1379481240&fm=27&gp=0.jpg"
        ,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3802752220,465206276&fm=27&gp=0.jpg"
        ,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3406230414,2315896161&fm=27&gp=0.jpg"
        ,"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=414019745,3119245420&fm=27&gp=0.jpg"};
        ArrayList<String> urlList = new ArrayList<String>();
        for (int i = 0; i < urls.length; i++) {
            urlList.add(urls[i]);
        }
        imageAdater.addAll(urlList);

        imageAdater.setOnItemClickListener(new BaseRecyAdapter.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(int pos, View itemView) {
                Intent intent = new Intent(MainActivity.this, ImageDetailActivity.class);
                View view = itemView.findViewById(R.id.item_iv);
                intent.putExtra("url",imageAdater.getItem(pos));
                intent.putExtra("transitionName", view.getTransitionName());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(view, view.getTransitionName()))
                        .toBundle());
            }
        });
    }
}
