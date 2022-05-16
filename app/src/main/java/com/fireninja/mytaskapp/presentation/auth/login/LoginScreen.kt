package com.fireninja.mytaskapp.presentation.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fireninja.mytaskapp.navigation.AuthNavGraph
import com.fireninja.mytaskapp.presentation.NavGraphs
import com.fireninja.mytaskapp.presentation.common.Greeting
import com.fireninja.mytaskapp.presentation.destinations.RegisterScreenDestination
import com.fireninja.mytaskapp.ui.theme.LARGE_PADDING
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@AuthNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(
  navigator: DestinationsNavigator,
) {
  val annotatedText = buildAnnotatedString {
    withStyle(
      style = SpanStyle(fontSize = MaterialTheme.typography.body1.fontSize)) {
      append("Don't have an account? ")
    }
    withStyle(style = SpanStyle(
      color = MaterialTheme.colors.primary,
      fontWeight = FontWeight.Bold,
      fontSize = MaterialTheme.typography.body1.fontSize
    )) {
      append("Register now!")
    }
  }

  Surface(modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background) {
    Column(
      modifier = Modifier.padding(LARGE_PADDING),
      verticalArrangement = Arrangement.Center,
    ) {
      TextField(
        value = "",
//        value = state.username,
        onValueChange = {
//          viewModel.onEvent(RegistrationFormEvent.UsernameChanged(it))
        },
//        isError = state.usernameError != null,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text(text = "Username")
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Email
        )
      )
//      if (state.usernameError != null) {
//        Text(
//          text = state.usernameError,
//          color = MaterialTheme.colors.error,
//          modifier = Modifier.align(Alignment.End)
//        )
//      }
      Spacer(modifier = Modifier.height(16.dp))

      TextField(
        value = "",
//        value = state.password,
        onValueChange = {
//          viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
        },
//        isError = state.passwordError != null,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text(text = "Password")
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
      )
//      if (state.passwordError != null) {
//        Text(
//          text = state.passwordError,
//          color = MaterialTheme.colors.error,
//          modifier = Modifier.align(Alignment.End)
//        )
//      }
      Spacer(modifier = Modifier.height(16.dp))

      ClickableText(
        text = annotatedText,
        onClick = {
          navigator.navigate(RegisterScreenDestination)
        },
        modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Spacer(modifier = Modifier.height(16.dp))

      Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
          navigator.navigate(NavGraphs.task)
        }
      ) {
        Text(text = "Login")
      }
    }
  }
}

@Preview
@Composable
fun PreviewLoginScreen() {
  LoginScreen(navigator = EmptyDestinationsNavigator)
}


