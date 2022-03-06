package com.work.mapping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.work.mapping.databinding.ActivityMainBinding
import com.work.mapping.model.LocationLatLngEntity
import com.work.mapping.model.searchResultEntity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SearchRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recycler 객체 초기화
        initAdapter()
        //view 객체를 초기화
        initViews()

        initData()

        setData()

    }


    private fun initViews() = with(binding) {
        Log.d("aaaaaaaaaa", "test123")
        emptyResultText.isVisible = false
        recyclerView.adapter = adapter
        Log.d("aaaaaaaaaa", "adapter")
    }

    private fun initAdapter() {
        Log.d("aaaaaaaaaa", "test12")
        adapter = SearchRecyclerAdapter()
    }

    private fun initData() {
        adapter.notifyDataSetChanged()
    }

    private fun setData() {
        val dataList = (0..10).map {
            searchResultEntity(
                name = "빌딩 $it",
                fullAdress = "주소 $it",
                locationLatLng = LocationLatLngEntity(
                    it.toFloat(),
                    it.toFloat()
                )
            )
        }
        adapter.setSearchResultList(dataList) {
            Toast.makeText(this, "빌딩 이름 : ${it.name} - 주소 : ${it.fullAdress} ", Toast.LENGTH_LONG)
                .show()
        }
    }
}
