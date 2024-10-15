package com.zhahira.detail_movie_buah.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhahira.detail_movie_buah.CustomeImage
import com.zhahira.detail_movie_buah.DetailBuahActivity
import com.zhahira.detail_movie_buah.R
import com.zhahira.detail_movie_buah.model.ModelBuah

class BuahAdapter( val itemList : ArrayList<ModelBuah>,
                   private val getActivity: CustomeImage //untuk bisa call intent,kita replace dg getactivity
) :
    RecyclerView.Adapter<BuahAdapter.ModelViewHolder>() {

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //deklarasi widget dari item layout
        lateinit var ItemImage: ImageView
        lateinit var ItemText: TextView

        init {
            ItemImage = itemView.findViewById(R.id.gambar) as ImageView
            ItemText = itemView.findViewById(R.id.nama) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customeimage, parent, false)
        return ModelViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.ItemImage.setImageResource(itemList[position].image)
        holder.ItemText.setText(itemList[position].deskripsi)

        //untuk klik detail
        holder.itemView.setOnClickListener() {
            //deklarasi intent
            val intent = Intent(getActivity, DetailBuahActivity::class.java)
            //baru put extra variable yang ingin di lempar atau passed
            intent.putExtra("deskripsi", itemList[position].deskripsi)
            intent.putExtra("image", itemList[position].image)
            //        intent.putExtra("judul", itemList[position].judul)
            //passed ke datil
            getActivity.startActivity(intent)
        }
    }
}