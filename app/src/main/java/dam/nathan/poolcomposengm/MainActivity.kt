package dam.nathan.poolcomposengm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dam.nathan.poolcomposengm.ui.theme.PoolComposeNGMTheme

val phIDEAL = 7.4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoolComposeNGMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario(
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Formulario(modifier: Modifier = Modifier) {
    var metrosCubicos by remember { mutableStateOf("") }
    var ph by remember { mutableStateOf("") }
    var gramos by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().padding(64.dp)) {
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = metrosCubicos,
                label = { Text("Metros cúbicos") },
                onValueChange = {
                    metrosCubicos = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = ph,
                label = { Text("Lectura de PH")},
                onValueChange =  {
                    ph = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = gramos,
                label = { Text("Gramos m³") },
                onValueChange = {
                    gramos = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }
        Row() {
        Text(
            if(metrosCubicos.isNotEmpty() && ph.isNotEmpty() && gramos.isNotEmpty()) {
                ((phIDEAL - ph.toDouble()) * 10 * metrosCubicos.toInt() * gramos.toInt()).toString()
            } else {
                "Debes rellenar todos los datos"
            },
            modifier = modifier.background(Color.Red).testTag("result")
        )
        }
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PoolComposeNGMTheme {
        Greeting("Android")
    }
}*/

@Preview(showBackground = true)
@Composable
fun FormularioPreview() {
    PoolComposeNGMTheme {
        Formulario()
    }
}