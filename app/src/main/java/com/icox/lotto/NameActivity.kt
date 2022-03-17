package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityNameBinding
import java.util.*
import kotlin.collections.ArrayList

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
            if (TextUtils.isEmpty(binding.edtName.text.toString())) {
                Toast.makeText(mContext, "이름을 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val myIntent = Intent(mContext, ResultActivity::class.java)
            myIntent.putIntegerArrayListExtra(
                "result",
                ArrayList(LottoNumberMaker.getLottoNumbersFromHash(binding.edtName.text.toString()))
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