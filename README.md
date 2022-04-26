# Jetpack Compose is like Android XML

Github Page: https://kibotu.github.io/jetpack-compose-is-like-android-view/


Inspired by [swift-is-like-kotlin](http://nilhcem.github.io/swift-is-like-kotlin/)

Compose Documentation: https://developer.android.com/jetpack/compose

Quick Equivalents: https://www.jetpackcompose.app/What-is-the-equivalent-of-FrameLayout-in-Jetpack-Compose

### How to build

```bash
yarn
yarn build
```

HTML is generated from [index.cirru](index.cirru).
Read that file, and you would know what's happening.

### License
<pre>
Copyright 2022 CHECK24 Profis

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
</pre>

### How to apply Google Maps

For the following steps the files should already be entered to gitignore. But it doesn't hurt to double check.

1. Put your Api key to demo/src/release/res/values/secrets.xml as a string resource.
2. Add your keystore (add to gitignore).
3. Add following to secrets.gradle (project scope):

```groovy
ext {
   STORE_FILE = "Your keystore path"
   STORE_PASSWORD = "Your password"
   KEY_ALIAS = "Your key alias"
   KEY_PASSWORD = "Your password"
}
```
   
4. Add google-services.json to demo.
5. You should select the release build variant. 
