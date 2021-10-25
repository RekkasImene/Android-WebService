package fr.mastersid.rekkas.websevices.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.rekkas.websevices.adapters.QuestionsListAdapter
import fr.mastersid.rekkas.websevices.databinding.QuestionsFragmentBinding
import fr.mastersid.rekkas.websevices.viewModels.QuestionsViewModel


@AndroidEntryPoint
class QuestionsFragment : Fragment() {

    private lateinit var _binding: QuestionsFragmentBinding
    private val questionModel: QuestionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = QuestionsFragmentBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val questionsListAdapter = QuestionsListAdapter()

        _binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = questionsListAdapter
        }

        _binding.refresh.setOnRefreshListener {
            questionModel.updateList()
        }

        questionModel.questions.observe(viewLifecycleOwner) { value ->
            _binding.refresh.isRefreshing = false
            questionsListAdapter.submitList(value)
        }

    }

}