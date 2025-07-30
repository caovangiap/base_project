package com.example.jetnewcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnewcompose.R


@Composable
fun PostCardSimple(modifier: Modifier) {

    val listPost = arrayListOf<String>("1","2","3","4")
    Column ( modifier = modifier) {
        listPost.forEach {
            Spacer(Modifier.height(16.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
            ) {
                ImagePostNew()
                Spacer(Modifier.width(10.dp))
                TitleContent(
                    modifier = Modifier.fillMaxWidth(0.6f)
                )
                Spacer(Modifier.weight(1f))
                BookMark(modifier = Modifier.align(Alignment.Top))
            }
            Spacer(Modifier.height(16.dp))
            HorizontalDivider()
        }
    }
}

@Composable
fun ImagePostNew(){
    val imageBox = Modifier
        .size(40.dp, 40.dp)
        .clip(RoundedCornerShape(6.dp))
    Image(
        painter = painterResource(R.drawable.post_1),
        contentDescription = null,
        modifier = imageBox,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TitleContent(modifier: Modifier) {
    Column (modifier = modifier) {
        PostTitle()
        AuthorAndReadTime()
    }
}

@Composable
fun PostTitle(){
    Text(
        text = "A Little Think About Android Module Paths",
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(bottom = 8.dp),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun AuthorAndReadTime() {

    Text(
        text = stringResource(
            id = R.string.home_post_min_read,
            formatArgs = arrayOf(
                "Pietro Maggi",
                1,
            ),
        ),
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun BookMark(modifier: Modifier){
    var bookMark = rememberSaveable  { mutableStateOf<Boolean>(false) }

    IconToggleButton(
        checked = bookMark.value,
        onCheckedChange = { bookMark.value = it },
        modifier = modifier
    ) {
        Icon(
            painter = if (bookMark.value) painterResource(R.drawable.ic_bookmark) else painterResource(R.drawable.ic_bookmark_outline),
            contentDescription = if (bookMark.value) "Selected icon button" else "Unselected icon button."
        )
    }
}


@Composable
@Preview
fun test(){
    PostCardSimple(modifier = Modifier)
}