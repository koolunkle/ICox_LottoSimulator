package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityMainBinding
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.randomCard.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            myIntent.putIntegerArrayListExtra(
                "result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers())
            )
            startActivity(myIntent)
        }
        binding.constellationCard.setOnClickListener {
            val myIntent = Intent(mContext, ConstellationActivity::class.java)
            startActivity(myIntent)
        }
        binding.nameCard.setOnClickListener {
            val myIntent = Intent(mContext, NameActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}