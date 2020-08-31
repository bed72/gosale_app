package com.bed.gosale.ui.market

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bed.gosale.data.model.Market
import com.bed.gosale.data.response.MarketBodyResponse
import com.google.firebase.firestore.FirebaseFirestore

// Tem que ser idependente não precisamos receber nada aqui, não podemos ter referencia de frame ou activity
class MarketViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    // Observables -> assina na instacia da classe não muda mais, ou seja imultavel
    val marketLiveData : MutableLiveData<List<Market>> = MutableLiveData()

    fun getMarkets() {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                val markets: MutableList<Market> = mutableListOf()
                for (document in result) {
                    document?.let {
                        val dataFirebase = it.data as Map<String, Any>
                        // Log.d("SUCCESS", "${document.id} => $dataFirebase")
                        //Log.d("BED", "-> ${dataFirebase["name"].toString()}")

                        val market = Market(
                            img = dataFirebase["img"].toString(),
                            name = dataFirebase["name"].toString(),
                            email = dataFirebase["email"].toString(),
                            phone = dataFirebase["phone"].toString(),
                            address = dataFirebase["address"].toString(),
                            description = dataFirebase["description"].toString()
                        )
                        markets.add(market)
                    }
                }
                marketLiveData.value = markets
            }
            .addOnFailureListener { exception ->
                Log.w("ERROR", "Error getting documents. $exception")
            }

    }
}