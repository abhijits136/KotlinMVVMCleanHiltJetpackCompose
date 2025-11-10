package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

object UiTokens {
    val spacing = 8.dp
    val buttonHeight = 48.dp
    val textFieldHeight = 56.dp
    val primaryColor = Color(0xFF6200EE)
    val disabledColor = Color(0xFFBDBDBD)
    val errorColor = Color(0xFFB00020)
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    iconRes: Int? = null,
    contentDescription: String? = null
) {
    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        modifier = modifier
            .semantics { contentDescription?.let { this.contentDescription = it } },
        contentPadding = PaddingValues(UiTokens.spacing),
        colors = ButtonDefaults.buttonColors(
            containerColor = UiTokens.primaryColor,
            disabledContainerColor = UiTokens.disabledColor
        )
    ) {
        if (iconRes != null) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                tint = Color.White
            )
        }
        Text(text = if (loading) "Loading..." else text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    leadingIconRes: Int? = null,
    trailingIconRes: Int? = null,
    contentDescription: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .semantics { contentDescription?.let { this.contentDescription = it } },
        label = label?.let { { Text(it) } },
        isError = isError,
        enabled = enabled,
        leadingIcon = leadingIconRes?.let {
            { Icon(painterResource(id = it), contentDescription = null) }
        },
        trailingIcon = trailingIconRes?.let {
            { Icon(painterResource(id = it), contentDescription = null) }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            disabledTextColor = UiTokens.disabledColor,
            errorIndicatorColor = UiTokens.errorColor
        ),
        visualTransformation = visualTransformation
    )
}
