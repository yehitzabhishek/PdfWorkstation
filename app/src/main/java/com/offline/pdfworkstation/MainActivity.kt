package com.offline.pdfworkstation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.offline.pdfworkstation.ui.theme.OfflinePDFWorkstationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfflinePDFWorkstationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PDFWorkstationScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
function PDFWorkstationScreen() {
    var statusText by remember { mutableStateOf("Ready for offline PDF operations") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Offline PDF Workstation") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to your Offline PDF Workstation",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = statusText,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                statusText = "Selected: Merge PDFs (Simulated Offline)"
            }) {
                Text("Merge PDFs")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                statusText = "Selected: Split PDF (Simulated Offline)"
            }) {
                Text("Split PDF")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                statusText = "Selected: Compress PDF (Simulated Offline)"
            }) {
                Text("Compress PDF")
            }
        }
    }
}