# Jetpack Compose is like Android XML

Github Page: https://check24-profis.github.io/jetpack-compose-is-like-android-view/


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


### How to apply Google Maps

For the following steps the files should already be entered to gitignore. But it doesn't hurt to double check.

1. Put your Api key to demo/src/release/res/values/secrets.xml as a string resource.
2. Add your keystore (add to gitignore).
3. Add following to secrets.gradle (project scope):

   groovy
ext {
   STORE_FILE = "Your keystore path"
   STORE_PASSWORD = "Your password"
   KEY_ALIAS = "Your key alias"
   KEY_PASSWORD = "Your password"
}

   
4. Add google-services.json to demo.
5. You should select the release build variant.

### Articles and Documentation

Text in Compose     https://developer.android.com/jetpack/compose/text
Keyboard Handling   https://dev.to/tkuenneth/keyboard-handling-in-jetpack-compose-2593
Constraint Layout   https://howtodoandroid.com/jetpack-compose-constraintlayout/
                    https://engineering.zalando.com/posts/2021/03/flexbox-layout-behavior-in-jetpack-compose.html
                    https://www.answertopia.com/jetpack-compose/jetpack-compose-constraintlayout-examples/
App Bars            https://www.jetpackcompose.net/scaffold
Modifiers           https://developer.android.com/jetpack/compose/modifiers
Lists               https://developer.android.com/jetpack/compose/lists
StaggeredGrid       https://medium.com/mobile-app-development-publication/staggeredverticalgrid-of-android-jetpack-compose-fa565e5363e1
Nice Tutorial App   https://github.com/SmartToolFactory/Jetpack-Compose-Tutorials
FAB                 https://compose.academy/blog/building_a_multi-action_floating_action_button_in_jetpack_compose
                    https://developer.android.com/jetpack/compose/layouts/material#fab
Radio Group         https://medium.com/nerd-for-tech/jetpack-compose-ep-8-radio-button-app-c3188d2fed5a
                    https://rrtutors.com/tutorials/How-to-create-radio-buttons-with-jetpack-compose
BottomAppBar        https://medium.com/@mumedian6/bottom-navigation-with-docked-fab-in-jetpack-compose-f1ba3cb3771b
                    https://www.android--code.com/2021/03/jetpack-compose-how-to-use-bottomappbar.html
Navigation          https://developer.android.com/jetpack/compose/navigation
                    https://proandroiddev.com/implement-bottom-bar-navigation-in-jetpack-compose-b530b1cd9ee2
Spinner             https://intensecoder.com/spinner-in-jetpack-compose-dropdown/
Card                https://www.jetpackcompose.net/jetpack-compose-card
Card Alignment      https://www.android--code.com/2021/09/jetpack-compose-card-alignment.html
Card Shapes         https://medium.com/@livinlawrence/android-material-design-cardview-shapes-3183363216b9
Chip                https://betterprogramming.pub/custom-jetpack-compose-chips-5609e742c54b
Chip Group          https://medium.com/@Rieger_san/create-a-chipgroup-with-jetpack-compose-f4744b94fa34
Toolbar             https://www.androiddevelopersolutions.com/2021/09/android-jetpack-compose-toolbar.html
Tabs                https://levelup.gitconnected.com/implement-android-tablayout-in-jetpack-compose-e61c113add79
States              https://developer.android.com/jetpack/compose/state
                    https://medium.com/@takahirom/jetpack-compose-state-guideline-494d467b6e76
StateHolder         https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects#5
Animation Spec      https://medium.com/mobile-app-development-publication/android-jetpack-compose-animation-spec-made-easy-6e7990aef203
GraphicsLayer       https://medium.com/mobile-app-development-publication/have-fun-with-jetpack-compose-graphicslayer-modifier-e39c12a4791f
Alert Dialog        https://foso.github.io/Jetpack-Compose-Playground/material/alertdialog/
Side-Effects        https://developer.android.com/jetpack/compose/side-effects

Cheat Sheet         https://victorbrandalise.com/roadmap-for-jetpack-compose/


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
