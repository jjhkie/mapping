package com.work.mapping

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.work.mapping.databinding.ViewholderSearchResultItemBinding
import com.work.mapping.model.searchResultEntity

class SearchRecyclerAdapter :
    RecyclerView.Adapter<SearchRecyclerAdapter.SearchResultItemViewHolder>() {


    private lateinit var searchResultClickListener: (searchResultEntity) -> Unit
    private var searchResultList: List<searchResultEntity> = listOf()

    class SearchResultItemViewHolder(val binding: ViewholderSearchResultItemBinding, val searchResultClickListener: (searchResultEntity) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: searchResultEntity) = with(binding) {
            Log.d("aaaaaa","inner SearchReslutItemViewHolder bindData")
            textTextView.text = data.name
            subtextTextView.text = data.fullAdress
        }

        fun bindViews(data: searchResultEntity){
            Log.d("aaaaaa","inner SearchReslutItemViewHolder bindViews")
            binding.root.setOnClickListener {
                searchResultClickListener(data)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultItemViewHolder {
        Log.d("aaaaaa","onCreateViewHolder  start")
        val view = ViewholderSearchResultItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )//뷰 객체를 받아온다.
        return SearchResultItemViewHolder(view, searchResultClickListener)
        Log.d("aaaaaa","onCreateViewHolder  end")
    }

    //여기서 데이터를 넣어준다.
    override fun onBindViewHolder(holder: SearchResultItemViewHolder, position: Int) {
        Log.d("aaaaaa","onBindViewHolder  start")
        holder.bindData(searchResultList[position])
        holder.bindViews(searchResultList[position])
        //searchResultList[position]
    }

    override fun getItemCount(): Int = searchResultList.size

    fun setSearchResultList(searchResultList: List<searchResultEntity>,searchResultClickListener:(searchResultEntity) -> Unit){
        this.searchResultList = searchResultList
        this.searchResultClickListener = searchResultClickListener
    }
}
