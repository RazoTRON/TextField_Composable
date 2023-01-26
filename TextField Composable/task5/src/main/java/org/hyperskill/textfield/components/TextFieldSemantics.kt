package org.hyperskill.textfield.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.text.input.TextFieldValue

val semTextFieldValueKey = SemanticsPropertyKey<String>("TextFieldValue")
var SemanticsPropertyReceiver.semTextFieldValue by semTextFieldValueKey

val semOnValueChangeStringKey = SemanticsPropertyKey<(String) -> Unit>("OnValueChangeString")
var SemanticsPropertyReceiver.semOnValueChangeString by semOnValueChangeStringKey

val semLeadingIconKey = SemanticsPropertyKey<@Composable (() -> Unit)?>("LeadingIcon")
var SemanticsPropertyReceiver.semLeadingIcon by semLeadingIconKey

val semTextFieldColorsContainerKey = SemanticsPropertyKey<Color>("TextFieldColorsContainer")
var SemanticsPropertyReceiver.semTextFieldColorsContainer by semTextFieldColorsContainerKey

val semTextFieldColorsTextKey = SemanticsPropertyKey<Color>("TextFieldColorsText")
var SemanticsPropertyReceiver.semTextFieldColorsText by semTextFieldColorsTextKey