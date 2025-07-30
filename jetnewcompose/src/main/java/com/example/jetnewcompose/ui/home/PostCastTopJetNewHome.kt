package com.example.jetnewcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun PostCastTopJetNewHome (modifier: Modifier) {
    Column(modifier = modifier){
        val shapeImage = Modifier
//            .heightIn(min = 180.dp, max = 180.dp)
            .height(180.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
        Image(
            painter = painterResource(R.drawable.post_6),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = shapeImage,
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Redesigning the Android Studio Logo",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(0.6f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Android Studio Team",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(
                id = R.string.home_post_min_read,
                formatArgs = arrayOf(
                    "May 10",
                    5,
                ),
            ),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}