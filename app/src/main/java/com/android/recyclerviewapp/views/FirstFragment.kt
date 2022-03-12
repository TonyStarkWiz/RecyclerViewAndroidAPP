package com.android.recyclerviewapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.recyclerviewapp.adapter.EventAdapter
import com.android.recyclerviewapp.databinding.FragmentFirstBinding
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventSingleton
import com.android.recyclerviewapp.views.FirstFragment.Companion.newInstance
import com.android.recyclerviewapp.views.SecondFragment.Companion.newInstance

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var event: Event? = null
    private var param2: String? = null

    private val binding by lazy{
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private var counter = 0

    // This is my adapter to used to change the data
    private val eventAdapter by lazy{
        EventAdapter(object : EventAdapter.onItemClickListener{
            override fun onItemClick(position: Event){
                fragmentNavigation(
                    supportFragmentManager = requireActivity().supportFragmentManager,
                    ThirdFragment.newInstance("", "")
                )
//                Toast.makeText(requireContext(),"You Clicked on item no. $position" ,
//                    Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getParcelable("event")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
                false)
            adapter = eventAdapter
        }

        EventSingleton.myNewEvent?.let {
            // EventSingleton.myListEvent.add(it)
            eventAdapter.updateEventData(it)
        }

        binding.addEvent.setOnClickListener{
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance()
            )
        }

        //return inflater.inflate(R.layout.fragment_first, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(event: Event? = null) = FirstFragment().apply {
            arguments = Bundle().apply {
                putParcelable("event", event)
            }
        }
    }
}