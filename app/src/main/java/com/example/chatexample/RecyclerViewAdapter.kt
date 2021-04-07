package com.example.chatexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (context: Context, list:ArrayList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    companion object{
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context: Context = context
    var list : ArrayList<Data> = list

    private inner class SenderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var message: TextView = itemView.findViewById(R.id.message)
        fun bind(position: Int)
        {
            val recyclerViewModel = list[position]
            message.text = recyclerViewModel.textData
        }

    }
    private inner class ReceiverViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.message)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            message.text = recyclerViewModel.textData
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when(viewType)
        {
            VIEW_TYPE_ONE ->
            {
                val view = LayoutInflater.from(context).inflate(R.layout.sendermessage,parent,false)
                SenderViewHolder(view)
            }
            VIEW_TYPE_TWO ->
            {
                val view = LayoutInflater.from(context).inflate(R.layout.receivermessage,parent,false)
                ReceiverViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }






    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(list[position].viewType)
        {
            VIEW_TYPE_ONE->
            {
                (holder as SenderViewHolder).bind(position)
            }
            VIEW_TYPE_TWO->
            {
                (holder as ReceiverViewHolder).bind(position)
            }
        }


    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }

}