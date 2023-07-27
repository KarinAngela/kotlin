package com.trevo.front.detalhe

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.trevo.front.R
import com.trevo.front.data.Produto
import com.trevo.front.databinding.ActivityDetalheBinding

class DetalheActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetalheBinding
    private val detalheViewModel by viewModels<DetalheViewModel> {
        DetalheViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appbarDetalhe)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = null

        val product: Produto? = intent.getParcelableExtra("product")
        if (product != null) {
            fillProductInformation(product)
        }

        val addButton: Button = findViewById(R.id.detalhe_button)
        addButton.setOnClickListener {
            if (product != null) {
                detalheViewModel.addToOrcamento(product)
                Toast.makeText(this, "\"${product.nome}\" foi adicionado ao orçamento!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun fillProductInformation(produto: Produto) {
        val imageView: ShapeableImageView = findViewById(R.id.detalhe_image_view)
        val tituloTextView: TextView = findViewById(R.id.detalhe_title)
        val descricaoTextView: TextView = findViewById(R.id.detalhe_descricao_produto)
        val culturaTextView: TextView = findViewById(R.id.detalhe_cultura)
        val areaSuportada: TextView = findViewById(R.id.detalhe_area_suportada)

        Picasso.get().load(produto.imageUrl).into(imageView)
        tituloTextView.text = produto.nome
        descricaoTextView.text = produto.descricaoProduto
        culturaTextView.text = produto.culturaUtilizada
        areaSuportada.text = produto.areaSuportada
    }
}