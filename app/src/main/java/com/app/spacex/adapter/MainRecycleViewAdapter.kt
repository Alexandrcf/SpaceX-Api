package com.app.spacex.adapter

import com.app.model.DataClass
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.spacex.R
import com.squareup.picasso.Picasso

class MainRecycleViewAdapter()
    : RecyclerView.Adapter<MainRecycleViewAdapter.ViewHolder>() {
    var dataArrayList = listOf<DataClass>()

    fun loadDataList(list:List<DataClass>) {
        if (dataArrayList != null) {
            dataArrayList = list
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.missionName?.text = dataArrayList[position].name
        holder.startDate?.text = dataArrayList[position].date_utc
        holder.textInfo?.text = dataArrayList[position].details

        val imageViewPhoto = holder.imageView

        Picasso.get().load(dataArrayList[position].links.patch.small).resize(100, 100).into(imageViewPhoto)
    }

    override fun getItemCount(): Int {
        return dataArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var missionName: TextView? = null
        var startDate: TextView? = null
        var textInfo: TextView? = null
        var imageView: ImageView? = null

        init {
            missionName = itemView.findViewById(R.id.mission_name)
            startDate = itemView.findViewById(R.id.start_date)
            textInfo = itemView.findViewById(R.id.text_info)
            imageView = itemView.findViewById(R.id.image_view)
        }

    }
}