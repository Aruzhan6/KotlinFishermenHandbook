package com.example.kotlinfishermenhandbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (lisrArray: ArrayList<ListItem>,context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    var listArrayR = lisrArray
    var contextR = context



    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val im = view.findViewById<ImageView>(R.id.im)

        fun bind(listItem: ListItem,context: Context){
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Presed : ${tvTitle.text}", Toast.LENGTH_SHORT)
                    .show()
                val i = Intent(context,ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())
                    putExtra("content", tvContent.text.toString())
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(i)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR)
    }

    override fun getItemCount(): Int {
       return listArrayR.size
    }
    fun updateAdapter(lisrArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(lisrArray)
        notifyDataSetChanged()
    }
}