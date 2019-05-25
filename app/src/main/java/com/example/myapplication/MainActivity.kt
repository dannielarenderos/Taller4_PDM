package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.BookAdapter
import com.example.myapplication.viewModel.ViewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bookAdapter: BookAdapter
    private lateinit var viewModelLibro: ViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelLibro= ViewModelProviders.of(this).get(ViewModels::class.java)

        bookAdapter= BookAdapter(this)

        Rv_Libro.layoutManager= LinearLayoutManager(this)
        Rv_Libro.adapter=bookAdapter

        viewModelLibro.allLibros.observe(this, Observer {
            listaLibritos->
            bookAdapter.cambioDeLista(listaLibritos)
        })

    }


}
