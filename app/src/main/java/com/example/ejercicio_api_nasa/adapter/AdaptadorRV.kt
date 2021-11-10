package com.example.ejercicio_api_nasa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio_api_nasa.R
import com.example.ejercicio_api_nasa.databinding.ItemRecyclerviewBinding
import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import com.squareup.picasso.Picasso

class AdaptadorRV() : RecyclerView.Adapter<AdaptadorRV.CustomViewHolder>() {

    private var lista: List<TerrenosModelItem> = ArrayList()
    private lateinit var miListener: alClickearItemRV

    class CustomViewHolder(
        private val binding: ItemRecyclerviewBinding,
        private val listener: alClickearItemRV
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(img: TerrenosModelItem) {
            //Picasso.get().load(img.img_src).into(binding.ivTerreno)

            Picasso.get().load(img.img_src).fit().centerCrop()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(binding.ivTerreno)
            binding.itemCard.setOnClickListener {

                listener.itemClick(adapterPosition)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), miListener
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setTerrenos(frases: List<TerrenosModelItem>) {
        lista = frases as ArrayList<TerrenosModelItem>
        notifyDataSetChanged()
    }

    interface alClickearItemRV {

        fun itemClick(position: Int)

    }

    fun setearListener(listener: alClickearItemRV) {

        miListener = listener
    }

}