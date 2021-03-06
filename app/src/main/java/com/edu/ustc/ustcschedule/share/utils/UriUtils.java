package com.edu.ustc.ustcschedule.share.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;

public class UriUtils {

    /**
     * 获取文件的Uri
     *
     * @param context  应用上下文
     * @param filePath 文件路径
     */
    public static Uri getUriFromFile(Context context, String filePath) {
        Uri uri;
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        }
        return uri;
    }
}

