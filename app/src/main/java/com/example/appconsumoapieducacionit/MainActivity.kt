package com.example.appconsumoapieducacionit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pintar()
        showError()
    }


    private fun pintar() {

        val text = findViewById<TextView>(R.id.textview)

        viewModel.ingredients.observe(this) {
            text.text = it[10]
        }
    }

    private fun showError(){
        viewModel.error.observe(this){
            if (it){
                Toast.makeText(this,"no tenes conexion",Toast.LENGTH_LONG).show()
            }
        }
    }
}
