package com.vrsingh.apps.dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vrsingh.apps.dictionary.databinding.MeaningRecyclerRowBinding

class MeaningAdapter(private var meaningList:List<Meaning>): RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {
    class MeaningViewHolder(private val binding: MeaningRecyclerRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(meaning: Meaning){
            binding.partOfSpeechTextview.text=meaning.partOfSpeech
            binding.definationsTextview.text=meaning.definitions.joinToString(separator = "\n\n"){
                var currentIndex=meaning.definitions.indexOf(it)
                (currentIndex+1).toString()+" "+it.definition.toString()
            }
            if(meaning.synonyms.isEmpty()){
                binding.synonymsTextview.visibility= View.GONE
                binding.synonymsTitleTextview.visibility= View.GONE
            }
            else{
                binding.synonymsTextview.visibility= View.GONE
                binding.synonymsTitleTextview.visibility= View.GONE
                binding.synonymsTextview.text=meaning.synonyms.joinToString { ", " }
            }
            if(meaning.antonyms.isEmpty()){
                binding.antonymsTextview.visibility= View.GONE
                binding.antonymsTitleTextview.visibility= View.GONE
            }
            else{
                binding.antonymsTextview.visibility= View.GONE
                binding.antonymsTitleTextview.visibility= View.GONE
                binding.antonymsTextview.text=meaning.synonyms.joinToString { ", " }
            }
        }
    }
    fun updateNewData(newMeaningList: List<Meaning>){
        meaningList=newMeaningList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val binding =MeaningRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MeaningViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return meaningList.size
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.bind(meaningList[position])
    }
}