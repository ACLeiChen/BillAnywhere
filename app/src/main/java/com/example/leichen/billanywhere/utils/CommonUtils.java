package com.example.leichen.billanywhere.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 * Created by Lei Chen on 2017/3/14.
 */

public class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static Reader loadJSONFromAsset(Context context, String jsonFileName)
            throws IOException {

        return new InputStreamReader(context.getAssets().open(jsonFileName), "UTF-8");
    }
}
