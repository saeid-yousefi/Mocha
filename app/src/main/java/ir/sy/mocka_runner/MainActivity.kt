package ir.sy.mocka_runner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ir.sy.mocha.core.mock
import ir.sy.mocha.resources.Languages
import ir.sy.mocka_runner.models.User
import ir.sy.mocka_runner.ui.theme.MockaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var mockedModel by remember {
                mutableStateOf<String?>(null)
            }
            MockaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView(mockedModel) {
                        val data = List(2) {
                            mock(language = Languages.Persian, clazz = User::class)
                        }
                        mockedModel = data.toString()
                    }
                }
            }
        }
    }
}

@Composable
fun MainView(mockedModelText: String?, onMockClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onMockClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Mock the user model")
        }
        Text(text = mockedModelText ?: "")
    }
}
