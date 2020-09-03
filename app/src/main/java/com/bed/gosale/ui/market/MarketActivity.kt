package com.bed.gosale.ui.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.R
import com.bed.gosale.ui.products.ProductsAdpter
import com.bed.gosale.ui.products.ProductsViewModel
import kotlinx.android.synthetic.main.activity_market.*


class MarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)

        // Atachando ViewModel -> Factory do Architecture Components
        val viewModel: MarketViewModel = ViewModelProviders.of(this).get(MarketViewModel::class.java)
        // Assinamos o canal para escutar o LiveData
        viewModel.marketLiveData.observe(this, {
            // caso seja nulo verifique, se não for entre no let
            it?.let { markets ->
                /*
            * Acessando a recycler do Mercado
            * para definir as configurações
            * com essa função não preciso ficar chamando o adapter sempre...
            */
                /** with -> 'com' **/
                with(recycler_markets) {
                    /**
                     * O contexto do 'layoutManager' tem que ser o contexto da class e não da minha
                     * função, para isso usamos o:
                     * 'this@MarketActivity' -> contexto de fora
                     **/
                    layoutManager = LinearLayoutManager(this@MarketActivity, RecyclerView.HORIZONTAL, false)
                    /* Os itens da lista tem um tamanho fixo, isso melhora a performace */
                    setHasFixedSize(true)
                    /** Precisamos passar a lista de mercados que vem do Firebase **/
                    adapter = MarketAdapter(markets)
                }
            }
        })
        // Ouvinte do liveData
        viewModel.getMarkets()


        /**
         * Products
         **/
        val viewModelProducts: ProductsViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)
        viewModelProducts.productLiveData.observe(this, {
            it?.let { products ->
                with(recycler_products) {
                    layoutManager = LinearLayoutManager(this@MarketActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = ProductsAdpter(products)
                }
            }
        })
        viewModelProducts.getAllProducts()
    }
}