package com.vaibhavmojidra.androidjetpackcomposedemostateusingmutablestateofandremember

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.androidjetpackcomposedemostateusingmutablestateofandremember.ui.theme.AndroidJetpackComposeDemoStateUsingMutableStateOfAndRememberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeDemoStateUsingMutableStateOfAndRememberTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        stateDemo()
                    }
                }
            }
        }
    }
}


//It is not recommended to have state as global also while re-composition happens can make it resets the value
@Composable
fun stateDemo(){
    val contxt= LocalContext.current
    val count= remember { mutableStateOf(0) }
    Button(onClick = {
        count.value=count.value+1
        Toast.makeText(contxt,"Count after click is ${count.value}",Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Count is ${count.value}", fontSize = 26.sp)
    }
}