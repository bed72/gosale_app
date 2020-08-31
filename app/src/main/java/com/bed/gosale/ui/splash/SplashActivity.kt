package com.bed.gosale.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import com.bed.gosale.ui.market.MarketActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    private val runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext, MarketActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}