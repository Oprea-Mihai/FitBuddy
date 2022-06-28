package com.example.fitbuddyapp.ui.exercises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitbuddyapp.R

class RecyclerAdapter(val onSelect:(position: Int)->Unit ) : RecyclerView.Adapter<ExerciseViewHolder>(){


    private  val title: List<String> = ExerciseObject.getTitles()
    private val detail:List<String> = ExerciseObject.getDetails()
    private val image:List<Int> = ExerciseObject.getImages()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder{

        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ExerciseViewHolder(v)
    }

    override fun onBindViewHolder(holder:ExerciseViewHolder, position: Int) {

        holder.itemTitle.text=title[position]
        holder.itemDetail.text=detail[position]
        holder.itemImage.setImageResource(image[position])

        holder.itemView.setOnClickListener {
            onSelect(position)
        }

    }

    override fun getItemCount():Int{
       return detail.size
    }

}

 class ExerciseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    var itemImage: ImageView=itemView.findViewById(R.id.item_image)
    var itemTitle:TextView=itemView.findViewById(R.id.item_title)
    var itemDetail:TextView=itemView.findViewById(R.id.item_detail)
}