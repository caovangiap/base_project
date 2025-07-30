package com.example.jetnewcompose.ui.home


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.core.base.utils.SubtitleStyle
import com.example.jetnewcompose.R

@Composable
@Preview
fun JetNewHome() {

    ConstraintLayout (
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 10.dp)
    ) {
        val (topTitle, postCastTopJetNew, horizontalPostCastTopJet,postCardSimple,postCardSimple2) = createRefs()
        Text(
            text = stringResource(id = R.string.top_title_jet_new),
            style = SubtitleStyle,
            modifier = Modifier.constrainAs(topTitle) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start)
                horizontalBias = 0f
            }
        )
        PostCastTopJetNewHome(
            modifier = Modifier.constrainAs(postCastTopJetNew){
                top.linkTo(topTitle.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        PostCardSimple(
            modifier = Modifier.constrainAs(postCardSimple){
                top.linkTo(postCastTopJetNew.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        HorizontalDivider(
            modifier = Modifier.constrainAs(horizontalPostCastTopJet) {
                top.linkTo(postCardSimple.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }

}