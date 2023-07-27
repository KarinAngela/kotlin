package com.trevo.front.orcamento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.trevo.front.R
import com.trevo.front.data.Produto

class OrcamentoAdapter(private val onClick: (Produto) -> Unit) :
    ListAdapter<Produto, OrcamentoAdapter.OrcamentoViewHolder>(OrcamentoDiffCallback) {

        class OrcamentoViewHolder(itemView: View, val onClick: (Produto) -> Unit) :
            RecyclerView.ViewHolder(itemView) {
                private val productTextView: TextView = itemView.findViewById(R.id.item_orcamento_title)
                private val productImageView: ImageView = itemView.findViewById(R.id.item_orcamento_image_view)
                private var currentProduct: Produto? = null

                init {
                    itemView.setOnClickListener {
                        currentProduct?.let {
                            onClick(it)
                        }
                    }
                }

                fun bind(product: Produto) {
                    currentProduct = product

                    productTextView.text = product.nome
                    Picasso.get().load(product.image_url).into(productImageView)
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrcamentoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_orcamento, parent, false)
            return OrcamentoViewHolder(view, onClick)
        }

        override fun onBindViewHolder(holder: OrcamentoViewHolder, position: Int) {
            val product = getItem(position)
            holder.bind(product)
        }
}

object OrcamentoDiffCallback: DiffUtil.ItemCallback<Produto>() {
    override fun areItemsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem.id == newItem.id
    }
}