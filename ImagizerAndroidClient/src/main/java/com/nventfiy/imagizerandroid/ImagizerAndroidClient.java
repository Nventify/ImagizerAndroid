package com.nventfiy.imagizerandroid;

import android.content.Context;
import android.util.DisplayMetrics;
import com.nventify.ImagizerClient;
import java.util.Map;

/**
 * Created by nick on 8/31/16.
 */
public class ImagizerAndroidClient extends ImagizerClient {

    private boolean autoDpr = false;
    private String format;
    private Context context;

    /**
     * Constructs Imagizer client
     *
     * @param context the current android context
     * @param host the hostname to the Imagizer instance
     */
    public ImagizerAndroidClient(String host, Context context) {
        super(host);
        this.context = context;
    }

    /**
     * Constructs Imagizer client
     *
     * @param context the current android context
     * @param useHttps whether to use https for the connection
     * @param host the hostname to the Imagizer instance
     */
    public ImagizerAndroidClient(String host, Boolean useHttps, Context context) {
        super(host, useHttps);
        this.context = context;
    }

    /**
     * Returns an Imagizer URL
     *
     * @param path the path of the image
     * @return ImagizerUrl
     */
    @Override
    public ImagizerAndroidUrl buildUrl(String path) {
        ImagizerAndroidUrl url = new ImagizerAndroidUrl(this.host, this.useHttps, path);

        if (this.autoDpr) {
            url.setDpr(getScreenScale());
        }

        if (this.format != null) {
            url.addParam("format", this.format);
        }

        url.setQuality(this.quality);

        return url;
    }

    /**
     * Returns an Imagizer URL with supplied params
     *
     * @param path   the path for the url
     * @param params the params to add to the url
     * @return ImagizerUrl
     */
    @Override
    public ImagizerAndroidUrl buildUrl(String path, Map<String, Object> params) {
        ImagizerAndroidUrl url = new ImagizerAndroidUrl(this.host, this.useHttps, path);

        if (this.autoDpr) {
            url.setDpr(getScreenScale());
        }

        url.setQuality(this.quality);

        url.addParams(params);

        if (this.format != null) {
            url.addParam("format", this.format);
        }

        return url;
    }

    /**
     * Returns true if auto DPR is set
     *
     * @return autoDpr whether using auto dpr or not
     */
    public boolean isAutoDpr() {
        return autoDpr;
    }

    /**
     * Sets whether using autoDpr or not
     **/
    public void setAutoDpr(boolean autoDpr) {
        this.autoDpr = autoDpr;
    }

    /**
     * Returns the device pixel ratio
     *
     * @return double the device pixel ratio
     */
    private double getScreenScale() {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }

    /**
     * Sets the default format for images
     *
     * @param format the type of image to return (jpeg, webp, auto)
     */
    public void setFormat(String format) {
        this.format = format;
    }
}
