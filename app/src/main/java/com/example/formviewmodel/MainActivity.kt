package com.example.formviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.formviewmodel.ui.theme.FormViewModelTheme
import com.example.formviewmodel.viewModel.PessoaViewModel
import androidx.compose.runtime.*
import com.example.formviewmodel.componentes.PasswordField


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   FormPessoa()
                }
            }
        }
    }
}



@Composable
fun FormPessoa() {
    val model: PessoaViewModel = viewModel()

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = model.nome, onValueChange = { model.nome = it})
        PasswordField(value = model.senha, onChange = { model.senha = it})
       // OutlinedTextField(value = model.senha, onValueChange = { model.senha = it})
        OutlinedTextField(value = model.dataNascimento, onValueChange = { model.dataNascimento = it})
        OutlinedTextField(value = model.email, onValueChange = { model.email = it})
        Button(onClick = {
            model.registrar()
        }) {
            Text(text = "Registrar")
        }
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FormViewModelTheme {
        Greeting("Android")
    }
}