package com.example.featurehome.ui

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.featurehome.R
import com.prodigy.feature.girlfriend.model.popularList.DataPopularList
import timber.log.Timber
import kotlin.apply
import kotlin.collections.forEach
import kotlin.collections.forEachIndexed
import kotlin.collections.lastIndex

class ImageSwipeImp(
    private val context: Context,
    private val container: ConstraintLayout,
    private val chatNow :(DataPopularList) -> Unit
) : ManagerImageSwipe {

    private val character = mutableListOf<DataPopularList>()
    private val listCard = mutableListOf<CustomImageSwipe>()

    fun submitListImgCharacter(listCharacter: MutableList<DataPopularList>) {
        // Clear old cards
        clearAllCards()
        
        // Update data
        character.clear()
        character.addAll(listCharacter)
        
        // Create and add new cards
        listCharacter.forEachIndexed { index, character ->
            val card = createCardView(character)
            addCardToContainer(card, index)
        }
    }
    
    private fun clearAllCards() {
        listCard.forEach { container.removeView(it) }
        listCard.clear()
    }
    
    private fun addCardToContainer(card: CustomImageSwipe, index: Int) {
        listCard.add(card)
        container.addView(card,index)
        setupCardConstraints(card)
        card.setStackTransform(character[index].rotitaonView)
    }
    
    private fun setupCardConstraints(card: CustomImageSwipe) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(container)

        // Copy tất cả constraints từ viewImgCharacter sang view mới
        val originalParams = container.findViewById<View>(R.id.viewImgCharacter)
            .layoutParams as ConstraintLayout.LayoutParams

        // Copy width và height
        constraintSet.constrainWidth(card.id, originalParams.width)
        constraintSet.constrainHeight(card.id, originalParams.height)

        // Copy tất cả constraints
        if (originalParams.topToTop != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.TOP,
                originalParams.topToTop,
                ConstraintSet.TOP
            )
        }
        if (originalParams.topToBottom != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.TOP,
                originalParams.topToBottom,
                ConstraintSet.BOTTOM
            )
        }
        if (originalParams.bottomToTop != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.BOTTOM,
                originalParams.bottomToTop,
                ConstraintSet.TOP
            )
        }
        if (originalParams.bottomToBottom != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.BOTTOM,
                originalParams.bottomToBottom,
                ConstraintSet.BOTTOM
            )
        }
        if (originalParams.startToStart != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.START,
                originalParams.startToStart,
                ConstraintSet.START
            )
        }
        if (originalParams.startToEnd != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.START,
                originalParams.startToEnd,
                ConstraintSet.END
            )
        }
        if (originalParams.endToStart != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.END,
                originalParams.endToStart,
                ConstraintSet.START
            )
        }
        if (originalParams.endToEnd != ConstraintLayout.LayoutParams.UNSET) {
            constraintSet.connect(
                card.id,
                ConstraintSet.END,
                originalParams.endToEnd,
                ConstraintSet.END
            )
        }

        // Copy margins
        constraintSet.setMargin(card.id, ConstraintSet.TOP, originalParams.topMargin)
        constraintSet.setMargin(card.id, ConstraintSet.BOTTOM, originalParams.bottomMargin)
        constraintSet.setMargin(card.id, ConstraintSet.START, originalParams.marginStart)
        constraintSet.setMargin(card.id, ConstraintSet.END, originalParams.marginEnd)

        // Copy các thuộc tính khác
        if (originalParams.matchConstraintPercentWidth > 0) {
            constraintSet.constrainPercentWidth(
                card.id,
                originalParams.matchConstraintPercentWidth
            )
        }
        if (originalParams.matchConstraintPercentHeight > 0) {
            constraintSet.constrainPercentHeight(
                card.id,
                originalParams.matchConstraintPercentHeight
            )
        }

        constraintSet.applyTo(container)
    }
    
    private fun createCardView(character: DataPopularList): CustomImageSwipe {
        val card = CustomImageSwipe(context).apply {
            id = View.generateViewId()
            setBackgroundColor(Color.TRANSPARENT)
            setCardBackgroundColor(Color.TRANSPARENT)
            elevation = 2f
            cardMoveOut = { imageMoveOut() }
            chatNowFun = { character -> chatNow(character) }
        }
        card.bindData(character)
        return card
    }

    override fun imageMoveOut() {
        Timber.tag("ImageSwipeImp").e("imageMoveOut")
        // remove old card
        listCard.removeAt(listCard.lastIndex)
        val lastCharacter = character.removeAt(character.lastIndex)

        // add new card to list
        character.add(0,lastCharacter)

        // new card
        val card = createCardView(lastCharacter)
        addCardToContainer(card,0)
        card.setStackTransform(lastCharacter.rotitaonView)
    }

}