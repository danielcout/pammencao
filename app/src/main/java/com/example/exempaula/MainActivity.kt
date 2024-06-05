package com.example.exempaula

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exempaula.ui.theme.DebugButtonColors
import com.example.exempaula.ui.theme.ErrorButtonColors
import com.example.exempaula.ui.theme.ExempAulaTheme
import com.example.exempaula.ui.theme.InfoButtonColors
import com.example.exempaula.ui.theme.WarningButtonColors

const val TAG = "Test Android"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExempAulaTheme{
                App()
            }
        }
    }
}
@Preview
@Composable
fun SimpleTextField(){
    var text by remember{ mutableStateOf("") }

    TextField(value = text, onValueChange = {}, label = { Text(text = "Nome do Aluno")})
}
@Composable
private fun App(){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.etec),
                contentDescription = "Etec ",
                modifier = Modifier.size(210.dp)
            )
            Greeting("JetPack")
            SimpleTextField()
            ActionButton(
                text = " B",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d(TAG, " B")
            }
            ActionButton(
                text = " MB",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, " MB")
            }
            ActionButton(
                text = " R",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(TAG, " R")
            }
            ActionButton(
                text = " I",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException(" I")
                } catch (ex: Exception) {
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}
@Composable



fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Atividade de Pam2",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color  =MaterialTheme.colorScheme.secondary
    )
}
@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview (){
    ExempAulaTheme {
        App()
    }
}
@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview (){
    ActionButton(text = "Cadastrar") {
    }
}
@Preview(showBackground = true, widthDp = 120)
@Composable
fun GreetingPreview (){
    ExempAulaTheme{
        Greeting("JetPack")
    }
}
