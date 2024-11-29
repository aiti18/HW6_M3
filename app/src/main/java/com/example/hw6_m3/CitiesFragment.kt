package com.example.hw6_m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sities, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewCities)

        val selectedCountry = arguments?.getString("country") ?: ""

        val cities = getCitiesForCountry(selectedCountry)

        val adapter = ItemAdapter(requireContext(), cities) { item ->
            val fullScreenImageDialog = FullScreenImageDialog.newInstance(item.imageResId)
            fullScreenImageDialog.show(parentFragmentManager, "full_screen_image")
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }

    private fun getCitiesForCountry(country: String): List<Item> {
        return when (country) {
            "Казахстан" -> listOf(
                Item("Алматы", R.drawable.almaty),
                Item("Нур-Султан", R.drawable.nur_sultan),
                Item("Шымкент", R.drawable.shymkent)
            )

            "Россия" -> listOf(
                Item("Москва", R.drawable.moscow),
                Item("Санкт-Петербург", R.drawable.spb),
                Item("Казань", R.drawable.kazan)
            )

            else -> {
                return listOf()
            }
        }
    }
}