package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.databinding.FragmentSecondBinding
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventSingleton
import java.text.SimpleDateFormat

class SecondFragment : Fragment() {

    private var dateParam: Long = 0
    private lateinit var formattedDate: String
    private lateinit var sdf: SimpleDateFormat

    private val binding by lazy{
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.doneBtn.setOnClickListener{
            EventSingleton.myNewEvent =
                Event(
                    binding.eventTitleEt.text.toString(),
                    binding.eventCategoryEt.text.toString(),
                    "$dateParam"
                )

            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.eventCalendar.setOnDateChangeListener { calendarView, i, i2, i3 ->
            val month = i2 + 1
            formattedDate = if (month <= 9) {
                if (i3 <= 9) {
                    "0$month/0$i3/$i"
                } else {
                    "0$month/$i3/$i"
                }
            } else {
                "$month/$i3/$i"
            }

        }.let {
            sdf = SimpleDateFormat("mm/dd/yyyy")
            formattedDate = sdf.format(binding.eventCalendar.date)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eventCalendar.setOnDateChangeListener{ calendarView, i, i2, i3 ->
            dateParam = calendarView.date
        }
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}