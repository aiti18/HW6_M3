package com.example.hw6_m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6_m3.databinding.FragmentContinentBinding
import java.util.ArrayList

class ContinentFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_continent, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewContinents)

        val continents = listOf(
            Item("Евразия", 0),
            Item("Африка", 0),
            Item("Америка", 0),
            Item("Австралия", 0),
            Item("Антарктида", 0)
        )

        val adapter = ItemAdapter(requireContext(), continents) { item ->
            val action = ContinentFragmentDirections.actionContinentFragmentToCountriesFragment(item.text)
            findNavController().navigate(action)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
}