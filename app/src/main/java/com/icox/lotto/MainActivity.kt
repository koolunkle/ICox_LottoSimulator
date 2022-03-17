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

    fun getRandomLottoNumber(): Int {
        return Random().nextInt(45) + 1
    }

    fun getRandomLottoNumbers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6) {
            var number = 0
            do {
                number = getRandomLottoNumber()
            } while (lottoNumbers.contains(number))
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (number in 1..45) {
            list.add(number)
        }
        list.shuffle()
        return list.subList(0, 6)
    }

    override fun setupEvents() {
        binding.randomCard.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            myIntent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
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