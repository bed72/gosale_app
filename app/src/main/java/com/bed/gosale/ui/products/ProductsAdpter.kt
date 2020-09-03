package com.bed.gosale.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.R
import com.bed.gosale.data.model.Products

class ProductsAdpter(
    private val products: List<Products>
) : RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.widget_item_product, parent, false)
        return  ProductsViewHolder(itemView)
    }

    override fun getItemCount() = products.count()

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindView(products[position])
    }
}