package com.example.kechuanqi.shareelement;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2018/3/12
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView implements Serializable{
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
