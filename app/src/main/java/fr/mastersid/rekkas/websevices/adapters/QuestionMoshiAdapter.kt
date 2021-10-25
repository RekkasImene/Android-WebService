package fr.mastersid.rekkas.websevices.adapters

import com.squareup.moshi.FromJson
import fr.mastersid.rekkas.websevices.models.ClassJsonToKotlin


class QuestionMoshiAdapter {

    @FromJson
    fun fromJson(classJsonToKotlin: ClassJsonToKotlin): List <Questions> {
        return classJsonToKotlin.items.map{
                Item -> Questions(Item.title, Item.answer_count)
        }

    }
}