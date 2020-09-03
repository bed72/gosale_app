package com.bed.gosale.ui.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.data.model.Products
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.widget_item_product.view.*

class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val picasso = Picasso.get()

    private val img = itemView.image_product

    private val name = itemView.name_product
    private val description = itemView.description_product

    fun bindView(product: Products) {
        picasso.load(product.image)
            .into(img)

        /* Setando no 'text' */
        name.text = product.name
        description.text = product.description
    }
}