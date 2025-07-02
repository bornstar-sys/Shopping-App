package com.example.shoppingapp.Presentation.Utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField // Material 2 OutlinedTextField
import androidx.compose.material.Text             // Material 2 Text
import androidx.compose.material.Icon            // Material 2 Icon - IMPORT ADDED
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String, // Your function correctly takes a String for the label
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    leadingIcon: ImageVector? = null, // Parameter to accept an ImageVector
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        // Corrected: The 'label' parameter of OutlinedTextField expects a Composable lambda.
        label = { Text(text = label) },
        modifier = modifier,
        singleLine = singleLine,
        // Corrected: The 'leadingIcon' parameter of OutlinedTextField also expects a Composable lambda.
        // We check if the passed 'leadingIcon' (ImageVector) is not null,
        // and if so, we provide a Composable lambda that renders an Icon.
        leadingIcon = leadingIcon?.let { // 'it' here is the non-null ImageVector
            { // This is the @Composable () -> Unit lambda for the leadingIcon parameter
                Icon(imageVector = it, contentDescription = null) // 'Icon' is now resolved
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}