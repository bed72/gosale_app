package com.bed.gosale.ui.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.R
import com.bed.gosale.data.model.Market

/**
* Classe para Adptar a recycler para minha tela
**/
class MarketAdapter(
    private val markets: List<Market>
) : RecyclerView.Adapter<MarketViewHolder>() {
    /* Criando ViewHolder com Layout -> Item Layout de cada um */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        /* Retornando ViewHolder
        *  O Contexto está no 'parent'
        */
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.widget_item_market, parent, false)
        return MarketViewHolder(itemView)
    }

    /* Retorna o tamanho dessa lista */
    override fun getItemCount() = markets.count()

    /* Ligação do item com a RecyclerView */
    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        /* Pansando de fato o objeto */
        holder.bindView(markets[position])
    }
}