package com.trevo.front.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.trevo.front.R
import com.trevo.front.data.Produto
import com.trevo.front.detalhe.DetalheActivity

class HomeAdapter() : ListAdapter<Produto, HomeAdapter.HomeViewHolder>(HomeDiffCallback) {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productTextView: TextView = itemView.findViewById(R.id.item_home_title)
        private val productImageView: ImageView = itemView.findViewById(R.id.item_home_image_view)
        private val productDetailButton: Button = itemView.findViewById(R.id.item_home_button)
        private var currentProduct: Produto? = null

        fun bind(product: Produto) {
            currentProduct = product

            productTextView.text = product.nome
            Picasso.get().load(product.imageUrl).into(productImageView)
            productDetailButton.setOnClickListener {
                val intent = Intent(itemView.context, DetalheActivity::class.java)
                intent.putExtra("product", product)
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }
}

object HomeDiffCallback: DiffUtil.ItemCallback<Produto>() {
    override fun areItemsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem.id == newItem.id
    }
}