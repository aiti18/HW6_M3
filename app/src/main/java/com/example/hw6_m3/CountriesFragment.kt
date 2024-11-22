package com.example.hw6_m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countries, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewCountries)

        val selectedContinent = arguments?.getString("continent") ?: ""

        val countries = getCountriesForContinent(selectedContinent)

        val adapter = ItemAdapter(requireContext(), countries) { item ->
            val citiesFragment = CitiesFragment().apply {
                arguments = Bundle().apply {
                    putString("country", item.text)
                }
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, citiesFragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

    private fun getCountriesForContinent(continent: String): List<Item> {
        return when (continent) {
            "Евразия" -> listOf(
                Item("Казахстан", 0),
                Item("Россия", 0)
            )
            "Африка" -> listOf(
                Item("Эфопия", 0),
                Item("Ангола", 0)
            )
            "Америка" -> listOf(
                Item("Канада", 0),
                Item("Греландия", 0)
            )
            "Австралия" -> listOf(
                Item("Новый Южный Уэльс", 0),
                Item("Виктория", 0)
            )
            "Антарктида" -> listOf(
                Item("Берег Амундсена", 0),
                Item("Земля Котса", 0)
            )
            else -> emptyList()
        }
    }
}