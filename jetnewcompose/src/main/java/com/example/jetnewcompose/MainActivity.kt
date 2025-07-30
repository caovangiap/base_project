package com.example.jetnewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.base.utils.DefaultToolBar
import com.example.jetnewcompose.ui.home.JetNewHome
import com.example.jetnewcompose.ui.theme.JetNewTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNewCompose()
        }
    }
}

@Composable
@Preview
fun JetNewCompose() {

    val rememberState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    JetNewTheme(dynamicColor = false){
        ModalNavigationDrawer(
            drawerState = rememberState,
            drawerContent = {
                JetNewDrawContent(closeDrawer = {coroutineScope.launch { rememberState.close() }} )
            },
            gesturesEnabled = true,
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
            ) {
                DefaultToolBar()
                JetNewHome()
            }
        }
    }
}



