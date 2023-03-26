package com.cupcake.chickenmasala.ui.adapter.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cupcake.chickenmasala.R
import com.cupcake.chickenmasala.data.model.Recipe
import com.cupcake.chickenmasala.databinding.RecipeCardHorizontalBinding
import com.cupcake.chickenmasala.databinding.RecipeCardVerticalBinding

class VerticalRecipeAdapter(private var recipeList: List<Recipe>): RecyclerView.Adapter<VerticalRecipeAdapter.VerticalRecipeViewHolder>() {

    class VerticalRecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = RecipeCardHorizontalBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card_horizontal,parent,false)
        return VerticalRecipeViewHolder(view)
    }

    override fun getItemCount() = recipeList.size

    override fun onBindViewHolder(holder: VerticalRecipeViewHolder, position: Int) {
        holder.binding.apply {
            recipeName.text = recipeList[position].translatedRecipeName
            cuisineName.text = recipeList[position].cuisine
            timer.text = recipeList[position].totalTimeInMin.toString()
            Glide.with(holder.itemView.context).load(recipeList[position].imageUrl).into(cardImage)
        }
    }

    fun setData(newRecipeList: List<Recipe>){
        recipeList = newRecipeList
        notifyDataSetChanged()
    }


}