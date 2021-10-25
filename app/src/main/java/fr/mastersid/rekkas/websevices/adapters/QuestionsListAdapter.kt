package fr.mastersid.rekkas.websevices.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import fr.mastersid.rekkas.websevices.R
import fr.mastersid.rekkas.websevices.models.Item

data class Questions(val title: String, val answerCount: Int) {
    class DiffCallback: DiffUtil.ItemCallback <Questions >() {
        override fun areItemsTheSame(oldItem: Questions , newItem: Questions): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: Questions , newItem: Questions): Boolean {
            return oldItem.title == newItem.title && oldItem.answerCount ==
                    newItem.answerCount
        }
    }
}

class QuestionsListAdapter:ListAdapter<Questions, QuestionsViewHolder>
    ( Questions.DiffCallback ()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val view = LayoutInflater . from ( parent . context )
            . inflate (R. layout . questions_item , parent , false )
        return QuestionsViewHolder( view )
    }

    @SuppressLint("StringFormatInvalid")
    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        val item = getItem(position)

        holder.title.text = "${item.title}"
        holder.answercount.text = "${item.answerCount}"
    }

}
