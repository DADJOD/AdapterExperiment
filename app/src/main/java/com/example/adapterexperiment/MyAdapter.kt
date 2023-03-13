package com.example.adapterexperiment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter : BaseAdapter() {
    private lateinit var inflater: LayoutInflater
    private lateinit var data: Array<String>

    fun setData(newData: Array<String>) {
        data = newData
    }

    override fun getCount(): Int {
        if (data != null) return data.size
        return 0
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView : View
        val myHolder : MyHolder
        if (convertView == null) {
            itemView = inflater.inflate(R.layout.item_layout, parent, false)
            val data1 = itemView.findViewById<TextView>(R.id.data1)
            val data2 = itemView.findViewById<TextView>(R.id.data2)
            val data3 = itemView.findViewById<TextView>(R.id.data3)
            myHolder = MyHolder(data1, data2, data3)
            itemView.tag = myHolder     // saved myHolder for the future
        } else {
            itemView = convertView
            myHolder = convertView.tag as MyHolder      // the future has come, got myHolder
        }

//        val itemView : View = convertView ?: inflater.inflate(R.layout.item_layout, parent, false) // for help our GarbageCollector


//        val data1 = itemView.findViewById<TextView>(R.id.data1)
//        val data2 = itemView.findViewById<TextView>(R.id.data2)
//        val data3 = itemView.findViewById<TextView>(R.id.data3)

        val item = getItem(position) as String
        myHolder.data1.text = item
        myHolder.data2.text = item.uppercase()
        myHolder.data3.text = item.lowercase()

        return itemView
    }

    class MyHolder(val data1: TextView, val data2: TextView, val data3: TextView) {

    }
}