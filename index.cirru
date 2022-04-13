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
      :href https://github.com/kibotu/jetpack-compose-is-like-android-view
      img#fork-me (:src http://kibotu.github.io/jetpack-compose-is-like-android-view/fork-me.png)
    #note
      = "Jetpack Compose is like AndroidView"

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
      .case (.name "Password With Visibility Toggle") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewPasswordVisibility.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewPasswordVisibility.xml)
      .case (.name "E-Mail") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewEmail.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewEmail.xml)
      .case (.name "Phone") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewPhoneNumber.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewPhoneNumber.xml)
      .case (.name "Postal Address") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/PostalAddress.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/PostalAddress.xml)
      .case (.name "Multiline Text") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/MultilineText.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/MultilineText.xml)
      .case (.name "Time") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/Time.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/Time.xml)
      .case (.name "Date") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextViewDate.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextViewDate.xml)
      .case (.name "Number") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/Number.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/Number.xml)
      .case (.name "Number (Signed)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/NumberSigned.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/NumberSigned.xml)
      .case (.name "Number (Decimal)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/NumberDecimal.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/NumberDecimal.xml)
      .case (.name "Auto Complete") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/AutoComplete.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/AutoComplete.xml)
      .case (.name "Text Input") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/text/TextInput.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/text/TextInput.xml)

    .section
      .title "Button"
      .case (.name "Image Button") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/ImageButton.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/ImageButton.xml)
      .case (.name "Chip Group") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/ChipGroup.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/ChipGroup.xml)
      .case (.name "Chip") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/Chip.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/Chip.xml)
      .case (.name "Check Box") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/CheckBox.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/CheckBox.xml)
      .case (.name "Radio Group") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/RadioGroup.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/RadioGroup.xml)
      .case (.name "Radio Button") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/RadioButton.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/RadioButton.xml)
      .case (.name "Toggle Button") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/ToggleButton.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/ToggleButton.xml)
      .case (.name "Switch") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/Switch.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/Switch.xml)
      .case (.name "Floating Action Button") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/button/FloatingActionButton.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/button/FloatingActionButton.xml)

    .section
      .title "List"
      .case (.name "List with different Views") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/list/ListWithDifferentViews.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/list/ListWithDifferentViews.xml)
      .case (.name "Grid") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/list/Grid.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/list/Grid.xml)
      .case (.name "Custom Fixed Grid") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/list/CustomFixedGrid.kt)
      .case (.name "Staggered") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/list/StaggeredVerticalGrid.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/list/StaggeredVerticalGrid.xml)

    .section
      .title "Layouts"
      .case (.name "Constraints") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/ConstraintLayoutContent.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/ConstraintLayoutContent.xml)
      .case (.name "Helper (Guideline Vertical)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/ConstraintLayoutGuideline.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/Guideline.xml)
      .case (.name "Helper (Guideline Horizontal)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/ConstraintLayoutGuidelineHorizontal.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/GuidelineHorizontal.xml)

      .case (.name "Helper (Barrier)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/ConstraintLayoutBarrier.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/Barrier.xml)
      .case (.name "Helper (Flow)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/HelperFlow.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/HelperFlow.xml)
      .case (.name "Helper (Layer)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/HelperLayer.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/HelperLayer.xml)
      .case (.name "FrameLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/FrameLayout.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/FrameLayout.xml)

    .section
      .title "Container"
      .case (.name "Spinner") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/Spinner.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/Spinner.xml)
      .case (.name "Horizontal Scrolling") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/HorizontalScrolling.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/HorizontalScrolling.xml)
      .case (.name "Vertical Scrolling") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/VerticalScrolling.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/VerticalScrolling.xml)
      .case (.name "ViewPager") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/ViewPager.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/ViewPager.xml)
      .case (.name "Card") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/Card.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/Card.xml)
      .case (.name "AppBarLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/AppBarLayout.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/AppBarLayout.xml)
      .case (.name "BottomAppBar") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/BottomAppBar.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/BottomAppBar.xml)
      .case (.name "Toolbar") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/Toolbar.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/Toolbar.xml)
      .case (.name "TabLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/TabLayout.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/TabLayout.xml)
      .case (.name "TabItem") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/TabItem.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/TabItem.xml)
      .case (.name "NavHost") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/container/NavHost.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/container/NavHost.xml)

    .section
      .title "Custom"
      .case (.name "Map") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/custom/GoogleMaps.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/custom/GoogleMaps.xml)

    .section
      .title "Modifier"
      .case (.name "Margin") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/modifier/margin.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/modifier/margin.xml)
      .case (.name "Size") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/modifier/size.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/modifier/size.xml)
      .case (.name "Clickable") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/modifier/clickable.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/modifier/clickable.xml)
      .case (.name "Shadow") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/modifier/shadow.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/modifier/shadow.xml)
      .case (.name "Background") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/modifier/background.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/modifier/background.xml)

    .section
      .title "Positioning"
      .case (.name "ConstraintLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/positioning/ConstraintLayout.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/positioning/ConstraintLayout.xml)
      .case (.name "Flow") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/positioning/Flow.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/positioning/Flow.xml)
      .case (.name "LinearLayout (Vertical)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/positioning/LinearLayoutVertical.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/positioning/LinearLayoutVertical.xml)
      .case (.name "LinearLayout (Horizontal)") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/positioning/LinearLayoutHorizontal.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/positioning/LinearLayoutHorizontal.xml)
      .case (.name "GridLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/list/Grid.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/list/Grid.xml)
      .case (.name "FrameLayout") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/layout/FrameLayout.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/layout/FrameLayout.xml)

    .section
      .title "States"
      .case (.name "Observable types") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/states/ObservableTypes.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/states/ObservableTypes.xml)
      .case (.name "Stateful") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/states/Stateful.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/states/Stateful.xml)
      .case (.name "Stateless with hoisting") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/states/Stateless.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/states/Stateless.xml)
      .case (.name "State holder") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/states/StateHolder.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/states/StateHolder.xml)
      .case (.name "ViewModel") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/states/ViewModel.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/states/ViewModel.xml)

    .section
      .title "Events"
      .case (.name "Event Flow") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/events/Events.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/events/Events.xml)

    .section
      .title "Material Theme"
      .case (.name "Theme") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/theme/theme.kt)
        .card (.lang Xml) $ pre.code $ code (@insert code/theme/theme.xml)

    .section
      .title "Side Effects"
      .case (.name "LaunchedEffect") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/sideeffects/LaunchedEffect.kt)
      .case (.name "DisposableEffect") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/sideeffects/DisposableEffect.kt)
      .case (.name "SideEffect") $ .pair
        .card (.lang Kotlin) $ pre.code $ code (@insert code/sideeffects/SideEffect.kt)