package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.adapter.EventAdapter
import com.android.recyclerviewapp.databinding.FragmentSecondBinding.inflate
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.properties.Delegates

class ThirdFragment : Fragment() {

    private var position by Delegates.notNull<Int>()
    private lateinit var formattedDate: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arguments?.let {
            position = it.getInt("position")
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            // TODO: Adapter
            //Toast.makeText(requireContext(), "$param1 $param2 $param3", Toast.LENGTH_LONG).show()
            val newAarryList = arrayListOf<Event>()
        }
    companion object {
        fun newInstance() = ThirdFragment()
    }
}
