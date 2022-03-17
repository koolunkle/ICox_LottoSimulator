package com.icox.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import com.icox.lotto.databinding.ActivityConstellationBinding
import java.util.*
import kotlin.collections.ArrayList

class ConstellationActivity : BaseActivity() {

    lateinit var binding: ActivityConstellationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_constellation)
        setupEvents()
        setValues()
    }

    fun makeConstellationString(month: Int, day: Int): String {
//        전달 받은 월/일 정보를 기반으로 정수 형태의 값을 만든다
//        ex) 1월 5일 -> 105, 11월 1일 -> 1101
        val target = "${month + 1}${String.format("%02d", day)}".toInt()
        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타 별자리"
        }
    }

    override fun setupEvents() {
        val datePicker = binding.datePicker
        val textView = binding.txtConstellation

        textView.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
        val calendar = Calendar.getInstance()
        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener {
                override fun onDateChanged(
                    view: DatePicker?,
                    year: Int,
                    monthOfYear: Int,
                    dayOfMonth: Int
                ) {
                    textView.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
                }

                override fun onSelectedDayChange(
                    view: CalendarView,
                    year: Int,
                    month: Int,
                    dayOfMonth: Int
                ) {

                }
            })
        binding.btnResult.setOnClickListener {
            val myIntent = Intent(mContext, ResultActivity::class.java)
            myIntent.putIntegerArrayListExtra(
                "result",
                ArrayList(
                    LottoNumberMaker.getLottoNumbersFromHash(
                        makeConstellationString(datePicker.month, datePicker.dayOfMonth)
                    )
                )
            )
            myIntent.putExtra(
                "constellation",
                makeConstellationString(datePicker.month, datePicker.dayOfMonth)
            )
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}