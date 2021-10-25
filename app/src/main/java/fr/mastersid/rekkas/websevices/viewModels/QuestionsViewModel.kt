package fr.mastersid.rekkas.websevices.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.rekkas.websevices.adapters.Questions
import fr.mastersid.rekkas.websevices.repository.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    private val _questionsList: MutableLiveData<List <Questions>> =
        MutableLiveData(emptyList())
    val questions: LiveData<List<Questions>> get() = _questionsList


    fun  updateList() {

        viewModelScope.launch(Dispatchers.IO) {
            _questionsList.postValue(
                questionsRepository.getQuestionList(order = DEFAULT_ORDER , sort = DEFAULT_SORT)
            )
        }


    }


    companion object {
        const val DEFAULT_ORDER = "desc"
        const val DEFAULT_SORT = "activity"
    }


}