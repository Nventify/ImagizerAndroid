# ImagizerEngine Android Client

The official Android Client for the Imagizer Media Engine.

The Imagizer Media Engine accelerates media delivery to your mobile Apps or Webpages by dynamically rescaling, cropping, and compressing images in real time. See all Imagizer features in our [doc](http://demo.imagizercdn.com/doc).

## Install from JCenter or Maven
```gradle
dependencies {
    compile 'com.nventify.imagizerandroid:ImagizerAndroidClient:0.1.1'
}
```

## Build Module from Source
```bash
gradle build
```

## Unit Tests
```bash
gradle test
```

## Basic Usage
Using the free to test Imagizer Demo Service 
```java
// Initialize the ImagizerEngine client
// Using the default initializer which points to the Imagizer Engine Demo service
// demo.imagizercdn.com
ImagizerAndroidClient imagizerClient = new ImagizerAndroidClient(this);

// Since we are using Imagizer Engine Demo Service
// we'll need to specify our Image storage origin
// Imagizer will fetch your images from this endpoint
// http://demo.imagizercdn.com/doc/#hostname
imagizerClient.setOriginHost("demo-images.imagizercdn.com");

// Enable Auto device pixel ratio setting.
// Device pixel ratio will now be detected
// and automatically applied to image urls
// http://demo.imagizercdn.com/doc/#dpr-device-pixel-ratio
imagizerClient.setAutoDpr(true);

// Compress our images by setting the global quality to 75
// http://demo.imagizercdn.com/doc/#quality
imagizerClient.setQuality(75);

// Scale the image by width.
// The height will be calculated by the aspect ratio of the source image.
// http://demo.imagizercdn.com/doc/#scale
String url1 = imagizerClient.buildUrl("image.jpg")
        .addParam("width", 300)
        .toString(); // return the URL in string format

// Prints
// http://demo.imagizercdn.com/image.jpg?dpr=2.6&hostname=demo-images.imagizercdn.com&quality=75&width=300
System.out.println(url);

// Crops any excess image data outside
// the width and height boundaries after scaling.
// The output image will match exactly the dimensions given.
// http://demo.imagizercdn.com/doc/#crop
String url2 = imagizerClient.buildUrl("image.jpg")
        .addParam("height", 300)
        .addParam("width", 300)
        .addParam("crop", "fit")
        .toString();

// Prints
// http://demo.imagizercdn.com/image.jpg?crop=fit&dpr=2.6&height=300&hostname=demo-images.imagizercdn.com&quality=75&width=300
System.out.println(url2);

        // Responsive images will be scaled and cropped automatically
// to fit perfectly into the image view no matter the device or screen size
ImageView imageView = (ImageView) findViewById(R.id.imageView);
String url3 = imagizerClient.buildUrl("image.jpg")
        .fitToView(imageView)
        .toString();

// Prints
// http://demo.imagizercdn.com/image.jpg?crop=fit&dpr=2.6&height=1109&hostname=demo-images.imagizercdn.com&quality=75&width=996
System.out.println(url3);        
```
Using your own Imagizer Instance
```java
// Initialize the ImagizerEngine client
// Pass your the host to your Imagizer Instance
// demo.imagizercdn.com
ImagizerAndroidClient imagizerClient = new ImagizerAndroidClient("example.com", this);

// Scale the image by width.
// The height will be calculated by the aspect ratio of the source image.
// http://demo.imagizercdn.com/doc/#scale
String url = imagizerClient.buildUrl("image.jpg")
        .addParam("width", 300)
        .toString(); // return the URL in string format
        
// Prints
// http://example.com/image.jpg?width=300
System.out.println(url);            
```

## Example Android Application
See our [example application](https://github.com/Nventify/ImagizerAndroidExample) for more details on bulding a basic photo app with the ImagizerEngine and an imageloader library such as the [Android Universal Image Loader](https://github.com/nostra13/Android-Universal-Image-Loader).
