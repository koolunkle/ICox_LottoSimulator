package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityNameBinding

class NameActivity : BaseActivity() {

    lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_name)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnGo.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            startActivity(myIntent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun setValues() {

    }
}