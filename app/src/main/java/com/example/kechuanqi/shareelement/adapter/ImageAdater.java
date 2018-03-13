package com.example.kechuanqi.shareelement.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.kechuanqi.shareelement.BaseRecyAdapter;
import com.example.kechuanqi.shareelement.MyImageView;
import com.example.kechuanqi.shareelement.R;

/**
 * @Description:
 * @Date: 2018/3/12
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class ImageAdater extends BaseRecyAdapter<String> {

    public ImageAdater(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(View.inflate(context,R.layout.item_image,null));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ImageViewHolder holder1 = (ImageViewHolder) holder;
        holder1.imageView.setTransitionName("image"+position);
        Glide.with(context)
                .load(getItem(position))
                .placeholder(R.mipmap.ic_launcher)
                .into(holder1.imageView);
    }

    class ImageViewHolder extends BaseViewHolder{
        private MyImageView imageView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (MyImageView) itemView.findViewById(R.id.item_iv);
        }
    }


}
