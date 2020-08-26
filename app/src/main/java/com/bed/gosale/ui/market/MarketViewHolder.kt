package com.bed.gosale.ui.market

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.data.model.Market
import kotlinx.android.synthetic.main.widget_item_market.view.*

/**
 * Classe que compoem meu Adpter
 * É a referência para a view que é a parte visual de cada
 * item da lista, que será replicada para todos elementos
 **/
class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name = itemView.nameMarket
    private val description = itemView.descriptionMarket

    fun bindView(market: Market) {
        /* Setando no 'text' */
        name.text = market.name
        description.text = market.description
    }
}