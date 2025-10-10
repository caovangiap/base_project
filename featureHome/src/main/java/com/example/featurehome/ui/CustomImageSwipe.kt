package com.example.featurehome.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.featurehome.R
import com.example.featurehome.databinding.ForYouCustomViewBinding
import com.prodigy.feature.girlfriend.model.popularList.DataPopularList
import timber.log.Timber
import kotlin.apply

@SuppressLint("ClickableViewAccessibility")
class CustomImageSwipe @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var lastX = 0f
    private var lastY = 0f
    private var isDragging = false

    private lateinit  var  binding: ForYouCustomViewBinding
    private lateinit var personaTagAdapter: PersonaTagAdapter

    val offsetPx = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        100f,
        context.resources.displayMetrics
    )
    val offsetPy = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        100f,
        context.resources.displayMetrics
    )

    var cardMoveOut: (() -> Unit)? = null
    var chatNowFun : ((DataPopularList)-> Unit)? = null

    init {
        inflate(context, R.layout.for_you_custom_view, this)
        binding = ForYouCustomViewBinding.inflate(LayoutInflater.from(context),this, true)
        setupRecyclerView()
        setOnTouchView()
    }

    private fun setupRecyclerView() {
        personaTagAdapter = PersonaTagAdapter()
        binding.listTag.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = personaTagAdapter
        }
    }

    private fun setOnTouchView(){
        setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = event.rawX
                    lastY = event.rawY
                    isDragging = true
                    animate().cancel()
                    alpha = 0.9f
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_MOVE -> {
                    val dx = event.rawX - lastX
                    val dy = event.rawY - lastY
                    translationX += dx
                    translationY += dy
                    rotation += (dx / width) * 30f
                    lastX = event.rawX
                    lastY = event.rawY
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    isDragging = false
                    alpha = 1f
                    determineDirectionFinger(translationX, translationY)
                    return@setOnTouchListener true
                }
                else -> false
            }
        }
    }

    fun bindData(character: DataPopularList){
        binding.introlCharacter.text = character.introduction
        binding.nameAndAgeCharacter.text = character.name
        binding.chatNow.setOnClickListener {
            chatNowFun?.invoke(character)
        }
        
        // Update persona tags RecyclerView
        personaTagAdapter.updateData(character.personaTags)

        Glide.with(context)
            .load(character.imageLink)
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.bg_meet_ai_partner)
                    .error(R.drawable.bg_meet_ai_partner)
            )
            .into(binding.imageItemCharacter)
    }

    private fun determineDirectionFinger(offsetX : Float, offsetY: Float) {
        val direction = when {
            offsetX < -offsetPx || offsetY < -offsetPy || offsetX > offsetPx || offsetY > offsetPy -> {
                when {
                    // Góc trái trên
                    offsetX < -offsetPx && offsetY < -offsetPy -> DirectionFinger.MoveLeftTop
                    // Góc phải trên  
                    offsetX > offsetPx && offsetY < -offsetPy -> DirectionFinger.MoveRightTop
                    // Góc trái dưới
                    offsetX < -offsetPx && offsetY > offsetPy -> DirectionFinger.MoveLeftDown
                    // Góc phải dưới
                    offsetX > offsetPx && offsetY > offsetPy -> DirectionFinger.MoveRightDown
                    // Chỉ di chuyển lên
                    offsetY < -offsetPy -> DirectionFinger.MoveTop
                    // Chỉ di chuyển xuống
                    offsetY > offsetPy -> DirectionFinger.MoveDown
                    // Chỉ di chuyển trái
                    offsetX < -offsetPx -> DirectionFinger.MoveLeft
                    // Chỉ di chuyển phải
                    offsetX > offsetPx -> DirectionFinger.MoveRight
                    else -> DirectionFinger.NotMoveOutImage
                }
            }
            // Không di chuyển ra ngoài
            else -> DirectionFinger.NotMoveOutImage
        }

        when (direction) {
            DirectionFinger.MoveLeftTop -> {
                animate()
                    .translationX(-width.toFloat() - 500)
                    .translationY(-height.toFloat() - 500)
                    .rotation(-30f)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveTop -> {
                animate()
                    .translationX(-width.toFloat() - 500)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveLeftDown->{
                animate()
                    .translationX(-width.toFloat() - 500)
                    .translationY(height.toFloat() + 500)
                    .rotation(-30f)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
           DirectionFinger.MoveRightDown -> {
                animate()
                    .translationX(width.toFloat() + 500)
                    .translationY(height.toFloat() + 500)
                    .rotation(30f)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveDown -> {
                animate()
                    .translationY(height.toFloat()+500)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveRightTop ->{
                animate()
                    .translationX(width.toFloat()+500)
                    .translationY(-height.toFloat()-500)
                    .rotation(30f)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveLeft ->{
                animate()
                    .translationX(-width.toFloat()-500)

                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.MoveRight ->{
                animate()
                    .translationX(width.toFloat()+500)
                    .setDuration(100)
                    .withEndAction { removeView(this@CustomImageSwipe) }
                    .start()
                cardMoveOut?.invoke()
            }
            DirectionFinger.NotMoveOutImage -> {
                animate()
                    .translationX(0f)
                    .translationY(0f)
                    .rotation(0f)
                    .setDuration(100)
                    .start()
            }
        }
    }

    fun setStackTransform(rotationView: Int) {
        rotation = if (rotationView%2==0){
            2f
        }else{
            -2f
        }
        if (rotationView==2){
            rotation = 0f
        }
    }



    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Timber.tag("CustomImageSwipe").e("even ACTION_DOWN: $event")
                return true
            }
            MotionEvent.ACTION_MOVE -> {

                Timber.tag("CustomImageSwipe").e("even ACTION_MOVE: $event")
            }
            MotionEvent.ACTION_UP -> {
                Timber.tag("CustomImageSwipe").e("even ACTION_UP: $event")
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

}

sealed class DirectionFinger{
    object MoveLeftTop : DirectionFinger()
    object MoveRightTop : DirectionFinger()
    object MoveLeftDown : DirectionFinger()
    object MoveRightDown : DirectionFinger()
    object MoveTop : DirectionFinger()
    object MoveDown : DirectionFinger()
    object MoveLeft : DirectionFinger()
    object MoveRight : DirectionFinger()
    object NotMoveOutImage : DirectionFinger()
}