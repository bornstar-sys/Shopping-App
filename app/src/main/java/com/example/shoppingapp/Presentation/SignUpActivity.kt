package com.example.shoppingapp.Presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingapp.Presentation.Utils.CustomTextField
import com.example.shoppingapp.R

@Composable
fun SignUp() {
    val context = LocalContext.current
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) } // For password field
    var showConfirmPassword by remember { mutableStateOf(false) } // For confirm password field

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SignUp",
            modifier = Modifier.padding(vertical = 30.dp).align(Alignment.Start),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold
        )
        CustomTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = "First Name",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Person
        )
        CustomTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = "Last Name",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Person
        )
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Mail",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Email
        )
        CustomTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = "Phone Number",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Phone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Lock,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (showPassword) "Hide password" else "Show password",
                        tint = Color.Black
                    )
                }
            }
        )
        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            leadingIcon = Icons.Filled.Lock,
            visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                    Icon(
                        imageVector = if (showConfirmPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (showConfirmPassword) "Hide confirm password" else "Show confirm password",
                        tint = Color.Black
                    )
                }
            }
        )
        Button(
            onClick = {
                if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                    if (password == confirmPassword) {
                        Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Password not matched", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_700))
        ) {
            Text(
                text = "SignUp",
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Already have an account?")
            TextButton(
                onClick = { /* Handle login navigation here */ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "Login",
                    color = colorResource(id = R.color.purple_700),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier.padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(text = "Or", modifier = Modifier.padding(horizontal = 16.dp))
            HorizontalDivider(modifier = Modifier.weight(1f))
        }
        OutlinedButton(
            onClick = { /* Handle signup logic here */ },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.white))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text("Login with Google", color = colorResource(id = R.color.black))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUp()
}