package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityConstellationBinding

class ConstellationActivity : BaseActivity() {

    lateinit var binding: ActivityConstellationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_constellation)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnResult.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}