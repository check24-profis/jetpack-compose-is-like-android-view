package de.check24.compose.demo.features.positioning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import de.check24.compose.demo.theme.DemoTheme
import de.check24.compose.demo.theme.Purple200

class ComposableConstraintLayoutPositioningActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {

            }
        }
    }
}

@Composable
private fun ConstraintLayoutPositioningExample() {
    ConstraintLayout() {
        val (purple, orange, blue, green, leftView, middleView, rightView) = createRefs()

        Text(
            textAlign = TextAlign.Center,
            text = "constraint to start, top and end of parent with a horizontal bias of 30/70",
            modifier = Modifier
                .padding(top = 80.dp)
                .width(150.dp)
                .background(Purple200)
                .padding(10.dp)
                .constrainAs(purple) {
                    linkTo(
                        parent.start,
                        parent.end,
                        bias = 0.3F
                    )
                }
        )

        Text(
            textAlign = TextAlign.Center,
            text = "circle constraint",
            modifier = Modifier
                .width(150.dp)
                .background(Color.Yellow)
                .padding(10.dp)
                .constrainAs(orange) {
                    circular(ConstrainedLayoutReference(purple), 135F, 110.dp)
                }
        )

        /*<TextView
        android:id="@+id/orange"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:background="@color/orange_200"
        android:gravity="center"
        android:padding="10dp"
        android:text="constraint via circle radius(110dp) and angle(135) to purple"
        app:layout_constraintCircle="@id/purple"
        app:layout_constraintCircleAngle="135"
        app:layout_constraintCircleRadius="110dp"
        tools:ignore="MissingConstraints" />*/
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun ConstraintLayoutPositioningPreview() {
    DemoTheme {
        ConstraintLayoutPositioningExample()
    }
}