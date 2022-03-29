val exampleColors: Colors
    get() = lightColors(
        primary = Color(0xFF862A8A),
        primaryVariant = Color(0xFFC280D5),
        onPrimary = Color(0xFFFFFFFF),

        secondary = Color(0xFFFF30FC),
        secondaryVariant = Color(0xFAEAF7FB),
        onSecondary = Color(0xFFFFFFFF),

        error = Color(0xFFC82D70),
        onError = Color(0xFFFFFFFF),

        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF333333),

        background = Color(0xFCEFEFF3),
        onBackground = Color(0xFFFFFFFF)
    )

val exampleTypography: Typography
    get() = Typography(
        h1 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        h2 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        h3 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        h4 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        h5 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Grey9,
            letterSpacing = 0.sp
        ),
        h6 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        subtitle1 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        subtitle2 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = Grey6,
            letterSpacing = 0.sp
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Grey9,
            letterSpacing = 0.sp
        ),
        button = TextStyle(
            fontSize = 16.sp,
            lineHeight = 18.sp,
            color = Color.White,
            letterSpacing = 0.sp
        ),
        caption = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Grey3,
            letterSpacing = 0.sp
        ),
        overline = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            color = Grey6,
            letterSpacing = 0.sp
        )
    )

val exampleShapes: Shapes
    get() = Shapes(
        small = RoundedCornerShape(0.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp)
    )

@Composable
fun ExampleTheme(content: @Composable () -&gt; Unit) {
    MaterialTheme(
        colors = exampleColors,
        typography = exampleTypography,
        shapes = exampleShapes,
        content = content
    )
}

// usable like this

@Composable
fun ExampleThemeDemo() {
    ExampleTheme {
        [...]
    }
}

// also can add to manifest

&lt;activity
    android:name=".features.theme.ComposableThemeActivity"
    android:exported="false"
    android:theme="@style/ExampleTheme" /&gt;