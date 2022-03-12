package com.android.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.model.Event
import com.android.recyclerviewapp.model.EventSingleton

class EventAdapter (
    private var mListener : onItemClickListener,
  private val eventList: MutableList<Event> = EventSingleton.myListEvent
        ): RecyclerView.Adapter<EventViewHolder> (){

    interface  onItemClickListener{
        fun onItemClick(position: Event)
    }

    // This method will update our date set
    fun updateEventData(event: Event) {
        eventList.add(0, event)
        eventList.sortBy { it.date }
        notifyItemInserted(eventList.indexOf(event))
        // eventList.sortBy { it.date } this is how your sort a list by  date
    }

    /* Here you are creating your view holder that holds your views to be bound
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        // here  i am inflating my EVENT ITEM coming from the XML file
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, mListener)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}

class EventViewHolder(itemView: View, private val listener: EventAdapter.onItemClickListener) :
    RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.event_title)
    private val category: TextView = itemView.findViewById(R.id.event_category)
    private val date: TextView = itemView.findViewById(R.id.event_date)

    fun bind(event: Event){
        title.text = event.title
        category.text = event.category
        date.text = event.date
        itemView.setOnClickListener {
            listener.onItemClick(event)
        }
    }
}