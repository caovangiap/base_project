package com.example.core.base.utils


import android.widget.Toast
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DefaultToolBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Title", style = TitleStyle )},
        navigationIcon = { IconButton(onClick = {})  { IconNavigationDefault()}},
        actions = {IconActionButton()}
    )
}

@Composable
fun IconNavigationDefault(){
    Icon(
        painterResource(R.drawable.ic_jetnews_logo),
        contentDescription = "menu",
        tint = MaterialTheme.colorScheme.primary)
}

@Composable
fun IconActionButton(){
    val context = LocalContext.current
    IconButton(onClick = {
        Toast.makeText(
            context,
            "Search is not yet implemented in this configuration",
            Toast.LENGTH_LONG,
        ).show()
    }) {
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = stringResource(R.string.title_tool_bar),
        )
    }
}