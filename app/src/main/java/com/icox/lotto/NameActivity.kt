package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityNameBinding
import kotlin.random.Random

class NameActivity : BaseActivity() {

    lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_name)
        setupEvents()
        setValues()
    }

    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (number in 1..45) {
            list.add(number)
        }
        list.shuffle(Random(name.hashCode().toLong()))
        return list.subList(0, 6)
    }

    override fun setupEvents() {
        binding.btnGo.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            myIntent.putIntegerArrayListExtra(
                "result",
                ArrayList(getLottoNumbersFromHash(binding.edtName.text.toString()))
            )
            myIntent.putExtra("name", binding.edtName.text.toString())
            startActivity(myIntent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun setValues() {

    }
}