package fr.mastersid.rekkas.websevices.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.mastersid.rekkas.websevices.R


class QuestionsViewHolder ( view : View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.title)
    val answercount: TextView =view.findViewById(R.id.answerCount)
}