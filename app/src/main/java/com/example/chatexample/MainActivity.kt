package com.example.chatexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private  lateinit var editText: EditText
    private lateinit var button: Button
    private val dataList = ArrayList<Data>()
    private var count =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         editText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        var adapter = RecyclerViewAdapter(this,dataList)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)



        button.setOnClickListener {
            var string = editText.text.toString()
            if(string!=null) {
                dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, string))

                count++
                response(string)

            }
            if(count==3)
            {
                dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "ok"))
                count = 0
            }





            adapter.notifyDataSetChanged()

            editText.text.clear()

        }





    }

    private fun response(string: String) {

        if(string=="Hello")
        {
            dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "Hii,How Are You"))

        }
        else if (string == "How are You")
        {
            dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "I am Fine"))
        }

    }
}