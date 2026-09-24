package com.example.componentesestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    var textInput by remember {
        mutableStateOf("")
    }
    val quantidade = remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var kotlin by remember {
        mutableStateOf(false)
    }
    var jCompose by remember {
        mutableStateOf(false)
    }
    var android by remember {
        mutableStateOf(false)
    }
    var sistemaSelecionado by remember {
        mutableStateOf("")
    }
    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }
    var favoritado by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)
    ) {
        Text(
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )

        Text(
            text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        AndroidEnemy(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.Black
        )

        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone pessoa",
                    tint = Color(66, 133, 244)
                )
            },
            value = textInput,
            onValueChange = { novoValor ->
                textInput = novoValor
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            label = {
                Text(text = "Nome e sobrenome")
            }
        )

        OutlinedTextField(
            value = quantidade.value,
            onValueChange = { novoValor ->
                quantidade.value = novoValor
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {
                Text(text = "Qual a quantidade?")
            }
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Digite seu email")
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Cyan
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jCompose,
                onCheckedChange = { jCompose = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Jetpack Compose")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = { android = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Android")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "mo",
                onClick = { sistemaSelecionado = "mo" }
            )
            Text("MacOs")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "wi",
                onClick = { sistemaSelecionado = "wi" }
            )
            Text("Windows")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == "li",
                onClick = { sistemaSelecionado = "li" }
            )
            Text("Linux")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color(0xFFB469E3)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF80EFA4),
                    contentColor = Color.White
                ),
                border = BorderStroke(4.dp, Color(0xFF29EC66)),
                shape = RoundedCornerShape(
                    topEnd = 12.dp,
                    bottomStart = 12.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star"
                )
                Text("Clique aqui!")
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color(0xFF80D0EF)
                }
            ) {
                Text("Outro botão")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (favoritado) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )
            } else {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border Icon",
                )
            }
        }
    }
}

@Composable
fun AndroidEnemy(
    modifier: Modifier = Modifier,
    color: Color
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}