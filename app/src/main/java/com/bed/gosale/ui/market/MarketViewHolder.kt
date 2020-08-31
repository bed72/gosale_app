package com.bed.gosale.ui.market

import android.R
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.data.model.Market
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.widget_item_market.view.*

/**
 * Classe que compoem meu Adpter
 * É a referência para a view que é a parte visual de cada
 * item da lista, que será replicada para todos elementos
 **/
class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val picasso = Picasso.get()

    private val img = itemView.image_market

    private val name = itemView.name_market
    private val description = itemView.description_market


    fun bindView(market: Market) {
        picasso.load(market.img)
            .into(img)

        /* Setando no 'text' */
        name.text = market.name
        description.text = market.description
    }
}