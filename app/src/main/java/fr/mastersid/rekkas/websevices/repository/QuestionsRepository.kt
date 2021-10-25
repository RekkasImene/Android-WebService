package fr.mastersid.rekkas.websevices.repository

import fr.mastersid.rekkas.websevices.adapters.Questions
import javax.inject.Inject

class QuestionsRepository @Inject constructor(
    private val stackOverFlowService: StackOverFlowService
) {
    suspend fun getQuestionList(order: String,
                                sort: String
                                ) : List <Questions> {
        return stackOverFlowService.getQuestionList(order = order, sort = sort)
    }
}

