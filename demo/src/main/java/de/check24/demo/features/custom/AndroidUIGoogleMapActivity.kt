package de.check24.demo.features.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import de.check24.demo.R


class AndroidUIGoogleMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.google_maps)
        supportActionBar?.title = "Google Maps"

        val mapFragment: SupportMapFragment? = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync {
            val c24Berlin = LatLng(52.51119997328961, 13.404559796099809)
            val zoom = 17F

            it.moveCamera(CameraUpdateFactory.newLatLngZoom(c24Berlin, zoom))
        }
    }
}