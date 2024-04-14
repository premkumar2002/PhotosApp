package com.example.photoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photoapp.ui.theme.PhotoAppTheme

class MainActivity : ComponentActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var cars = arrayOf("Car1","Car2","Car3","Car4","car5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next=findViewById<ImageButton>(R.id.btnNext)
        val prev=findViewById<ImageButton>(R.id.btnPrev)
        val carName=findViewById<TextView>(R.id.tvName)

        next.setOnClickListener {
            var idCurrentImageString="pic$currentImage"
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (5 + currentImage + 1)%5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)

            image = findViewById(idImageToShowInt)
            image.alpha=1f

            carName.text=cars[currentImage]
        }

        prev.setOnClickListener {
            var idCurrentImageString="pic$currentImage"
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (5 + currentImage - 1)%5
            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)

            image = findViewById(idImageToShowInt)
            image.alpha=1f

        }
    }
}
