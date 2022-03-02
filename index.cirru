doctype

html
  head
    title "Jetpack Compose is like Android XML"
    meta (:charset utf-8)
    link (:rel icon)
      :href http://logo.cirru.org/cirru-32x32.png
      :type image/png
    link (:rel stylesheet)
      :href https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.3.0/styles/github.min.css
    style (@insert css/style.css)
    script (:src https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.3.0/highlight.min.js)
    script (:src https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.3.0/languages/kotlin.min.js)
    script (:src https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.3.0/languages/xml.min.js)
    script (:defer true) "hljs.highlightAll();"

  body
    a (:target _blank)
      :href https://github.com/kibotu/jetpack-compose-is-like-android-xml
      img#fork-me (:src http://kibotu.github.io/jetpack-compose-is-like-android-xml/fork-me.png)
    #note
      = "Jetpack Compose is like Android-XML"

    .section
      .title Text
      .case (.name "Plain Text") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextView.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextView.xml)
      .case (.name "Password") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewPassword.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewPassword.xml)
      .case (.name "Password (Numeric)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewNumberPassword.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewNumberPassword.xml)
      .case (.name "E-Mail") $ .pair
      .case (.name "Phone") $ .pair
      .case (.name "Postal Address") $ .pair
      .case (.name "Multiline Text") $ .pair
      .case (.name "Time") $ .pair
      .case (.name "Date") $ .pair
      .case (.name "Number") $ .pair
      .case (.name "Number (Signed)") $ .pair
      .case (.name "Number (Decimal)") $ .pair
      .case (.name "Auto Complete") $ .pair
      .case (.name "Text Input") $ .pair

    .section
      .title "Button"
      .case (.name "Image Button") $ .pair
      .case (.name "Chip Group") $ .pair
      .case (.name "Chip") $ .pair
      .case (.name "Check Box") $ .pair
      .case (.name "Radio Group") $ .pair
      .case (.name "Radio Button") $ .pair
      .case (.name "Toggle Button") $ .pair
      .case (.name "Switch") $ .pair
      .case (.name "Floating Action Button") $ .pair

    .section
      .title "List"
      .case (.name "List with different Views") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/ListWithDifferentViews.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/ListWithDifferentViews.xml)
      .case (.name "Grid") $ .pair
      .case (.name "Staggered") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/StaggeredVerticalGrid.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/StaggeredVerticalGrid.xml)

    .section
      .title "Layouts"
      .case (.name "Constraints") $ .pair
      .case (.name "Helper (Group)") $ .pair
      .case (.name "Helper (Barrier)") $ .pair
      .case (.name "Helper (Flow)") $ .pair
      .case (.name "Helper (Layer)") $ .pair
      .case (.name "FrameLayout") $ .pair

    .section
      .title "Container"
      .case (.name "Spinner") $ .pair
      .case (.name "Horizontal Scrolling") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/HorizontalScrolling.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/HorizontalScrolling.xml)
      .case (.name "Vertical Scrolling") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/VerticalScrolling.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/VerticalScrolling.xml)
      .case (.name "ViewPager") $ .pair
      .case (.name "Card") $ .pair
      .case (.name "AppBarLayout") $ .pair
      .case (.name "BottomAppBar") $ .pair
      .case (.name "Toolbar") $ .pair
      .case (.name "TabLayout") $ .pair
      .case (.name "TabItem") $ .pair
      .case (.name "FragmentContainer") $ .pair
      .case (.name "NavHost") $ .pair

    .section
      .title "Custom"
      .case (.name "Map") $ .pair

    .section
      .title "Modifier"

    .section
      .title "Positioning"

    .section
      .title "States"

    .section
      .title "Events"

    .section
      .title "Material Theme"