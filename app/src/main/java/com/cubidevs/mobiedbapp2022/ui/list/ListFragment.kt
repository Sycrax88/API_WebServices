package com.cubidevs.mobiedbapp2022.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.databinding.FragmentListBinding
import com.cubidevs.mobiedbapp2022.server.model.FreeGame

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var gamesList: ArrayList<FreeGame> = ArrayList()
    private lateinit var gamesAdapter: GamesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gamesAdapter = GamesAdapter(gamesList, onItemClicked = { })

        listBinding.gamesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = gamesAdapter
            setHasFixedSize(false)
        }

        listViewModel.gamesLoaded.observe(viewLifecycleOwner){ result ->
            onMoviesLoadedSubscribe(result)
        }

        listViewModel.getMovies()
    }

    private fun onMoviesLoadedSubscribe(gamesList: ArrayList<FreeGame>?) {
        gamesList?.let { gamesList ->
            gamesAdapter.appendItems(gamesList)
        }
    }
}