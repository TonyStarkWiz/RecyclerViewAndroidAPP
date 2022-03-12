package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.databinding.FragmentSecondBinding
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventSingleton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    private var dateParam: Long = 0

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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}