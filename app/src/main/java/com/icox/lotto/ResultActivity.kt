package com.icox.lotto

import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityResultBinding

class ResultActivity : BaseActivity() {

    lateinit var binding: ActivityResultBinding

    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        setupEvents()
        setValues()
        val result = intent.getIntegerArrayListExtra("result")
        result?.let {
            updateLottoBallImage(result.sortedBy { it })
        }
    }

    fun updateLottoBallImage(result: List<Int>) {
        if (result.size < 6) return
        val imageView01 = findViewById<ImageView>(R.id.imageView01)
        val imageView02 = findViewById<ImageView>(R.id.imageView02)
        val imageView03 = findViewById<ImageView>(R.id.imageView03)
        val imageView04 = findViewById<ImageView>(R.id.imageView04)
        val imageView05 = findViewById<ImageView>(R.id.imageView05)
        val imageView06 = findViewById<ImageView>(R.id.imageView06)

        imageView01.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView02.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView03.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView04.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView05.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView06.setImageResource(lottoImageStartId + (result[5] - 1))
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}