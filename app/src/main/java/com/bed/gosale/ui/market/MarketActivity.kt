package com.bed.gosale.ui.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.R
import kotlinx.android.synthetic.main.activity_market.*


class MarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)

        // Atachando ViewModel -> Factory do Architecture Components
        val viewModel: MarketViewModel = ViewModelProviders.of(this).get(MarketViewModel::class.java)
        // Assinamos o canal para escutar o LiveData
        viewModel.marketLiveData.observe(this, Observer {
            // caso seja nulo verifique, se não for entre no let
            it?.let { markets ->
                /*
            * Acessando a recycler do Mercado
            * para definir as configurações
            * com essa função não preciso ficar chamando o adapter sempre...
            */
                /** with -> 'com' **/
                with(recycleMarket) {
                    /**
                     * O contexto do 'layoutManager' tem que ser o contexto da class e não da minha
                     * função, para isso usamos o:
                     * 'this@MarketActivity' -> contexto de fora
                     **/
                    layoutManager = LinearLayoutManager(this@MarketActivity, RecyclerView.VERTICAL, false)
                    /* Os itens da lista tem um tamanho fixo, isso melhora a performace */
                    setHasFixedSize(true)
                    /** Precisamos passar a lista de mercados que vem do Firebase **/
                    adapter = MarketAdapter(markets)
                }
            }
        })
        // Ouvinte do liveData
        viewModel.getMarkets()
    }

}