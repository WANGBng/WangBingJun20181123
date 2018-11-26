package com.bwie.application;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import butterknife.ButterKnife;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig diskCacheConfig = builder.build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,config);
    }
}
