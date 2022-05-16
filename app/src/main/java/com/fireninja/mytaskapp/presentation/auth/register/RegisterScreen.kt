package com.fireninja.mytaskapp.presentation.auth.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.fireninja.mytaskapp.navigation.AuthNavGraph
import com.fireninja.mytaskapp.presentation.NavGraphs
import com.fireninja.mytaskapp.presentation.common.Greeting
import com.fireninja.mytaskapp.presentation.destinations.LoginScreenDestination
import com.fireninja.mytaskapp.presentation.destinations.RegisterScreenDestination
import com.fireninja.mytaskapp.ui.theme.LARGE_PADDING
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@AuthNavGraph
@Destination
@Composable
fun RegisterScreen(
  navigator: DestinationsNavigator,
) {
  val annotatedText = buildAnnotatedString {
    withStyle(
      style = SpanStyle(fontSize = MaterialTheme.typography.body1.fontSize)) {
      append("Already have an account? ")
    }
    withStyle(style = SpanStyle(
      color = MaterialTheme.colors.primary,
      fontWeight = FontWeight.Bold,
      fontSize = MaterialTheme.typography.body1.fontSize
    )) {
      append("Try logging in!")
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
//        value = state.email,
        onValueChange = {
//          viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
        },
//        isError = state.emailError != null,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text(text = "Email")
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Email
        )
      )
//      if (state.emailError != null) {
//        Text(
//          text = state.emailError,
//          color = MaterialTheme.colors.error,
//          modifier = Modifier.align(Alignment.End)
//        )
//      }
      Spacer(modifier = Modifier.height(16.dp))

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

      TextField(
        value = "",
//        value = state.repeatedPassword,
        onValueChange = {
//          viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))
        },
//        isError = state.repeatedPasswordError != null,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text(text = "Repeat password")
        },
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
      )
//      if (state.repeatedPasswordError != null) {
//        Text(
//          text = state.repeatedPasswordError,
//          color = MaterialTheme.colors.error,
//          modifier = Modifier.align(Alignment.End)
//        )
//      }
      Spacer(modifier = Modifier.height(16.dp))

      ClickableText(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = annotatedText,
        onClick = {
          navigator.navigate(LoginScreenDestination)
        }
      )
      Spacer(modifier = Modifier.height(16.dp))

      Button(
        modifier = Modifier.align(Alignment.End).fillMaxWidth(),
        onClick = {
//          viewModel.onEvent(RegistrationFormEvent.Submit)
          navigator.navigate(NavGraphs.task)
        },
      ) {
        Text(text = "Register")
      }

    }
  }
}
