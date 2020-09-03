package com.bed.gosale.ui.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.bed.gosale.data.model.Products
import com.google.firebase.firestore.FirebaseFirestore

class ProductsViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    val productLiveData : MutableLiveData<List<Products>> = MutableLiveData()

    fun getAllProducts() {
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val products: MutableList<Products> = mutableListOf()

                for (document in result) {
                    document?.let {
                        val dataFirebase = it.data as Map<String, Any>
                        Log.d("SUCCESS", "${document.id} => $dataFirebase")
                        //Log.d("BED", "-> ${dataFirebase["name"].toString()}")

                        val product = Products(
                            image = dataFirebase["image"].toString(),
                            name = dataFirebase["name"].toString(),
                            description = dataFirebase["description"].toString()
                        )
                        products.add(product)
                    }
                }
                productLiveData.value = products
            }
            .addOnFailureListener { exception ->
                Log.w("ERROR", "Error getting documents. $exception")
            }
    }
}