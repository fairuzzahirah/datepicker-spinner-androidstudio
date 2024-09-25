package com.example.dataactivity

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dataactivity.databinding.ActivityMainBinding
import com.example.dataactivity.dialog.DatePickerDialog
import com.example.dataactivity.dialog.TimePicker

class MainActivity : AppCompatActivity(), android.app.DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    private val binding by lazy {
        ActivityMainBinding.inflate(this.layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val stringGender = resources.getStringArray(R.array.gender)
        val stringCountry = listOf(
            "Indonesia",
            "China",
            "Korea"
        )
        with(binding){
            val adapterSpinnerGender = ArrayAdapter(this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,stringGender)
            spinnerGender.adapter = adapterSpinnerGender
            spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    p2: Int,
                    p3: Long
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        stringGender.get(p2),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        datePicker.init(
            datePicker.year,
            datePicker.month,
            datePicker.dayOfMonth
        ){ _ , year , month , day
            -> val selectedDate = "$day/${(month+1)}/$year"
            Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()

        }
        timePicker.setOnTimeChangedListener {view, hour, minute ->
            val selectedTime = String.format("%02d:%02d", hour, minute)
            Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
        }
        }
    }
    fun showCalendar(view: View) {
        val datePicker = DatePickerDialog()
        datePicker.show(supportFragmentManager,"datePicker")
    }

    override fun onDateSet(
        p0: DatePicker?,
        p1: Int,
        p2: Int,
        p3: Int
    ) {
        val selectedDate = "$p1/${p2+1}/$p3"
        Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()
    }
    fun showTimePicker(view: View){
        val timePicker = TimePicker()
        timePicker.show(supportFragmentManager,"timePicker")
    }

    override fun onTimeSet(p0: android.widget.TimePicker?, p1: Int, p2: Int) {
        val time = String.format("%02d:%02d",p1,p2)
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
    }

//    fun showAlert(view: View) {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("ini pesan")
//        builder.setMessage("halo, saya dialog")
//        builder.setPositiveButton("Ya"){ dialog, _ ->
//            finish()
//        }
//        builder.setNegativeButton("Tidak"){ dialog, _ ->
//            dialog.dismiss()
//        }
//        val dialog = builder.create()
//        dialog.show()
//    }
    fun showAlert(view: View) {
        val builder = AlertDialog.Builder(this).apply {}
        builder.setTitle("ini pesan")
        builder.setMessage("halo, saya dialog")
        builder.setPositiveButton("Ya"){ dialog, _ ->
            finish()
        }
        builder.setNegativeButton("Tidak"){ dialog, _ ->
            dialog.dismiss()
        }
    }

}
//format string itu ada banyak kodenya, cb search aja weh.