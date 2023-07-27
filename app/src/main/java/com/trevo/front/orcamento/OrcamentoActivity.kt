package com.trevo.front.orcamento

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.trevo.front.R
import com.trevo.front.data.Produto
import com.trevo.front.databinding.ActivityOrcamentoBinding

class OrcamentoActivity: AppCompatActivity() {
    private lateinit var binding: ActivityOrcamentoBinding

    private val orcamentoViewModel by viewModels<OrcamentoViewModel> {
        OrcamentoViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrcamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appbarOrcamento)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val orcamentoAdapter = OrcamentoAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.orcamento_recycler_view)
        recyclerView.adapter = orcamentoAdapter

        orcamentoViewModel.productsLiveData.observe(this) {
            it?.let {
                orcamentoAdapter.submitList(it as MutableList<Produto>)
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
}