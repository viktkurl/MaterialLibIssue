package ru.kve.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import androidx.core.util.Pair

class MainActivity : AppCompatActivity() {

    private var picker by Delegates.notNull<MaterialDatePicker<Pair<Long, Long>>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createPicker()
        open_picker.setOnClickListener { showPicker() }
    }

    private fun createPicker() {
        val builder = MaterialDatePicker.Builder.dateRangePicker()

        val constraintsBuilder = CalendarConstraints.Builder()
        builder.setCalendarConstraints(constraintsBuilder.build())
        builder.setTitleText("Заголовок")
        builder.setTheme(R.style.DatePickerTheme)
        picker = builder.build()
    }

    private fun showPicker() {
        picker.show(supportFragmentManager, picker.toString())
    }
}
