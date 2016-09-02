package com.nventfiy.imagizerandroid;

import android.view.View;
import com.nventify.ImagizerUrl;
import java.util.Map;

/**
 * Created by nick on 9/1/16.
 */
public class ImagizerAndroidUrl extends ImagizerUrl {

    /**
     * Construct Imagizer URL
     *
     * @param host     the hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path     the path of the image
     */
    public ImagizerAndroidUrl(String host, Boolean useHttps, String path) {
        super(host, useHttps, path);
    }

    /**
     * Construct Imagizer URL
     *
     * @param host     the Hostname of the Imagizer instance
     * @param useHttps whether to use https or not
     * @param path     the path of the image
     * @param params   the parameters to add to the url
     */
    public ImagizerAndroidUrl(String host, Boolean useHttps, String path, Map<String, Object> params) {
        super(host, useHttps, path, params);
    }

    /**
     * Return an Imagizer Android Url with scale
     * auto generated to fit within a specified image view
     *
     * @param view the image view to fit the image into
     * @return ImagizerAndroidUrl
     */
    public ImagizerAndroidUrl scaleToView(View view) {
        int height = view.getHeight();
        int width = view.getWidth();

        if (width > 0) {
            this.params.put("width", width);
        }

        if (height > 0) {
            this.params.put("height", height);
        }

        return this;
    }

    /**
     * Return an Imagizer Android Url with scale and crop
     * auto generated to fit within a specified image view
     *
     * @param view the image view to fit the image into
     * @return ImagizerAndroidUrl
     */
    public ImagizerAndroidUrl fitToView(View view) {
        this.params.put("crop", "fit");

        return scaleToView(view);
    }
}
