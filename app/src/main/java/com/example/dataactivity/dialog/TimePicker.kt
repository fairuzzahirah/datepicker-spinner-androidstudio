package com.example.dataactivity.dialog

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.app.Dialog
import android.app.TimePickerDialog
import android.text.format.DateFormat
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import com.example.dataactivity.R


class TimePicker : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(
            requireActivity(), activity as TimePickerDialog.OnTimeSetListener,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )


    }
}