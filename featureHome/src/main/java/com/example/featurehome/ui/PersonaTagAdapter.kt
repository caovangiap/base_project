package com.example.featurehome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapp.R
import com.example.featurehome.databinding.ItemTagForYouBinding
import com.prodigy.feature.girlfriend.model.popularList.PersonaTag
import kotlin.text.replace

class PersonaTagAdapter : RecyclerView.Adapter<PersonaTagAdapter.PersonaTagViewHolder>() {

    private var personaTags: List<PersonaTag> = emptyList()

    fun updateData(tags: List<PersonaTag>) {
        personaTags = tags
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaTagViewHolder {
        val binding = ItemTagForYouBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonaTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonaTagViewHolder, position: Int) {
        holder.bind(personaTags[position])
    }

    override fun getItemCount(): Int = personaTags.size

    class PersonaTagViewHolder(
        private val binding: ItemTagForYouBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(personaTag: PersonaTag) {
            val text = personaTag.name
            val cleaned = text.replace(Regex("[^A-Za-z0-9\\s]"), "")
            binding.tagCharacter.text = cleaned

            val positon : Int = absoluteAdapterPosition.div(5)

            val positionBackground = if (positon==0){
                absoluteAdapterPosition
            }else{
                val position = absoluteAdapterPosition%5
                position
            }

            when(positionBackground){
                0 ->{
                    if (absoluteAdapterPosition==0){
                        binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_1)
                    }else{
                        binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_6)
                    }
                }
                1->{
                    binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_2)
                }
                2->{
                    binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_3)
                }
                3->{
                    binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_4)
                }
                4->{
                    binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_5)
                }
                5->{
                    binding.tagCharacter.setBackgroundResource(R.drawable.bg_border_1000_tag_6)
                }
            }
        }
    }

}
