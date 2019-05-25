package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.R.layout.viewholderlibro
import com.example.myapplication.database.Entities.LibroEntity
import kotlinx.android.synthetic.main.viewholderlibro.view.*

class BookAdapter internal constructor(context: Context) : RecyclerView.Adapter<BookAdapter.ViewHolder>(){

    var books: List<LibroEntity> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

      //  fun bind(book: LibroEntity){
      //      itemView.Tv_titulo.text=book.titulo
       //       itemView.Tv_summary.text=book.resumen
      //  }
        fun bind(book: LibroEntity)= with(itemView){
          Glide
                  .with(this)
                  .load(book.caratula)
                  .centerCrop()
                  .into(Iv_book_portada);
          Tv_book_name.text=book.titulo
          Tv_summary.text=book.resumen
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.viewholderlibro, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        vh.bind(books[position])
    }

    fun cambioDeLista(nuevosBooks : List<LibroEntity>){
        books= nuevosBooks
        notifyDataSetChanged()
    }

}