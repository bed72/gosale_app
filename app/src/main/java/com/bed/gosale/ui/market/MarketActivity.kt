package com.bed.gosale.ui.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bed.gosale.R
import com.bed.gosale.data.model.Market
import kotlinx.android.synthetic.main.activity_market.*


class MarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)

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
            adapter = MarketAdapter(getMarkets())
        }
    }
    /* Simulando dados */
    private fun getMarkets(): List<Market> {
        return listOf(
            Market(
                "Bastos",
                "O melhor mercado do Guarujá!"
            ),

            Market(
                "Martendal",
                "O melhor mercado de Lages!"
            ),

            Market(
                "Stock",
                "Preço baixo e aqui!"
            )
        )
    }
}