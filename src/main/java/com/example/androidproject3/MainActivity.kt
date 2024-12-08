package com.example.androidproject3

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set references for each button and the image
        imageView = findViewById(R.id.imageView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        // Create an initial TransitionDrawable with a placeholder image
        val initialDrawable = TransitionDrawable(arrayOf(
            resources.getDrawable(R.drawable.img_5394), // Initial image
            resources.getDrawable(R.drawable.img_5394)  // Same image as placeholder
        ))

        imageView.setImageDrawable(initialDrawable)

        // Handle button clicks to change images with transition
        button1.setOnClickListener {
            val transitionDrawable = TransitionDrawable(arrayOf(
                imageView.drawable,
                resources.getDrawable(R.drawable.img_5394)
            ))
            imageView.setImageDrawable(transitionDrawable)
            transitionDrawable.startTransition(1000) // 1 second transition
        }

        button2.setOnClickListener {
            val transitionDrawable = TransitionDrawable(arrayOf(
                imageView.drawable,
                resources.getDrawable(R.drawable.img_5060)
            ))
            imageView.setImageDrawable(transitionDrawable)
            transitionDrawable.startTransition(1000)
        }

        button3.setOnClickListener {
            val transitionDrawable = TransitionDrawable(arrayOf(
                imageView.drawable,
                resources.getDrawable(R.drawable.a875a938ef0dfd73dd3b6428088d0bda)
            ))
            imageView.setImageDrawable(transitionDrawable)
            transitionDrawable.startTransition(1000)
        }
    }
}
