package com.example.findmyip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.findmyip.viewmodel.IpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: IpViewModel = viewModel()
            val ipInfo = viewModel.ipInfo.value
            val isLoading = viewModel.isLoading.value
            val errorMessage = viewModel.errorMessage.value

            Column(
                modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                } else {
                    ipInfo?.let {
                        Text(text = "IP: ${it.ip}")
                        Text(text = "City: ${it.city}")
                        Text(text = "Region: ${it.region}")
                        Text(text = "Country: ${it.country_name}")
                    }
                }

                errorMessage?.let {
                    Text(text = it, color = Color.Red)
                }

                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = { viewModel.fetchInfo() }) {
                    Text(text = "Fetch IP Info")
                }
            }
        }
    }
}