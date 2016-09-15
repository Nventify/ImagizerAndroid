package com.nventfiy.imagizerandroid;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Mock
    Context mMockContext;

    @Test
    public void testBuildUrl() {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg", url);
    }

    @Test
    public void testBuildUrlWithSlash() {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        String url = client.buildUrl("/image.jpg").toString();

        assertEquals("http://example.com/image.jpg", url);
    }


    @Test
    public void testBuildUrlWithAddParams() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);

        String url = client.buildUrl("image.jpg")
                .addParam("width", 200)
                .addParam("height", 400)
                .addParam("crop", "fit")
                .toString();

        assertEquals("http://example.com/image.jpg?crop=fit&height=400&width=200", url);
    }

    @Test
    public void testBuildUrlWithHashMap() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("width", 200);
        params.put("height", 400);

        ImagizerAndroidUrl imagizerUrl = client.buildUrl("image.jpg", params);

        assertEquals("http://example.com/image.jpg?height=400&width=200", imagizerUrl.toString());
    }

    @Test
    public void testBuildUrlWithQuality() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);

        String url = client.buildUrl("image.jpg")
                .addParam("quality", 100)
                .toString();

        assertEquals("http://example.com/image.jpg?quality=100", url);
    }

    @Test
    public void testBuildUrlWithGlobalQuality() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg?quality=100", url);
    }

    @Test
    public void testBuildUrlWithGlobalQualityOverride() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").addParam("quality", 99).toString();

        assertEquals("http://example.com/image.jpg?quality=99", url);
    }

    @Test
    public void testBuildUrlWithDpr() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);

        String url = client.buildUrl("image.jpg")
                .addParam("dpr", 2)
                .toString();

        assertEquals("http://example.com/image.jpg?dpr=2", url);
    }

    @Test
    public void testBuildUrlWithGlobalDpr() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://example.com/image.jpg?dpr=2", url);
    }

    @Test
    public void testBuildUrlWithGlobalDprOverride() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient("example.com", mMockContext);
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").addParam("dpr", 2.3).toString();

        assertEquals("http://example.com/image.jpg?dpr=2.3", url);
    }


    @Test
    public void testBuildUrlWithDefaultDemoHost() {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?hostname=example.com", url);
    }

    @Test
    public void testBuildUrlWithDefaultDemoHostAndOriginHostSpecified() {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?hostname=example.com", url);
    }

    @Test
    public void testBuildUrlWithAddParamsWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("width", 200)
                .addParam("height", 400)
                .addParam("crop", "fit")
                .toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?crop=fit&height=400&hostname=example.com&width=200", url);
    }

    @Test
    public void testBuildUrlWithHashMapWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("width", 200);
        params.put("height", 400);

        ImagizerAndroidUrl imagizerUrl = client.buildUrl("image.jpg", params);

        assertEquals("http://demo.imagizercdn.com/image.jpg?height=400&hostname=example.com&width=200", imagizerUrl.toString());
    }

    @Test
    public void testBuildUrlWithQualityWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("quality", 100)
                .toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?hostname=example.com&quality=100", url);
    }

    @Test
    public void testBuildUrlWithGlobalQualityWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?hostname=example.com&quality=100", url);
    }

    @Test
    public void testBuildUrlWithGlobalQualityOverrideWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");
        client.setQuality(100);

        String url = client.buildUrl("image.jpg").addParam("quality", 99).toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?hostname=example.com&quality=99", url);
    }

    @Test
    public void testBuildUrlWithDprWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");

        String url = client.buildUrl("image.jpg")
                .addParam("dpr", 2)
                .toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?dpr=2&hostname=example.com", url);
    }

    @Test
    public void testBuildUrlWithGlobalDprWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?dpr=2&hostname=example.com", url);
    }

    @Test
    public void testBuildUrlWithGlobalDprOverrideWithDefaultDemoHostAndOriginHostSpecified() throws Exception {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setOriginHost("example.com");
        client.setDpr(2);

        String url = client.buildUrl("image.jpg").addParam("dpr", 2.3).toString();

        assertEquals("http://demo.imagizercdn.com/image.jpg?dpr=2.3&hostname=example.com", url);
    }

    @Test
    public void testHttpsImagizerInstance() {
        ImagizerAndroidClient client = new ImagizerAndroidClient("demo.imagizercdn.com", true, mMockContext);
        String url = client.buildUrl("test.jpg").toString();

        assertEquals("https://demo.imagizercdn.com/test.jpg", url);
        assertTrue(client.isUseHttps());
    }

    @Test
    public void testAutoDpr() {
        ImagizerAndroidClient client = new ImagizerAndroidClient(mMockContext);
        client.setAutoDpr(true);

        String url = client.buildUrl("test.jpg").toString();
        assertEquals("http://demo.imagizercdn.com/test.jpg", url);
        assertTrue(client.isAutoDpr());
    }
}