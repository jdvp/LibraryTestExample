package me.jdvp.librarytestexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var dialog1Visible by remember { mutableStateOf(false) }
    var dialog2Visible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(20.dp)) {
        Button(onClick = { dialog1Visible = true }) {
            Text(text = stringResource(R.string.button_1))
        }

        Button(onClick = { dialog2Visible = true }) {
            Text(text = stringResource(R.string.button_2))
        }
    }

    if (dialog1Visible) {
        SimpleDialog(
            title = stringResource(R.string.button_1_dialog_title),
            message = stringResource(R.string.button_1_dialog_message),
            onDismiss = { dialog1Visible = false }
        )
    }

    if (dialog2Visible) {
        SimpleDialog(
            title = stringResource(R.string.button_2_dialog_title),
            message = stringResource(R.string.button_2_dialog_message),
            onDismiss = { dialog2Visible = false }
        )
    }
}

@Composable
fun SimpleDialog(title: String, message: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(R.string.ok))
            }
        }
    )
}
