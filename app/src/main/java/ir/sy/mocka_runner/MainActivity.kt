package ir.sy.mocka_runner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.sy.mocha.Mocha
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.types.IntType
import ir.sy.mocha.mocker.types.LongType
import ir.sy.mocha.mocker.types.StringType
import ir.sy.mocka_runner.ui.theme.MockaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MockaTheme {
                val context = LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var model by remember {
                        mutableStateOf("Mocked model:")
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = model, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {
                            model = Mocha(context).mock<Foo>().toString()
                            println(model)
                        }) {
                            Text(text = "Mocha")
                        }
                    }
                }
            }
        }
    }
}

data class Foo(
    val phone: String,
    val id: Int,
    val timestamp: Long,
    @MockInt(type = IntType.Price) val idk2: Int,
    @MockString(defaultValue = "Hello world") val loremIpsum2: String,
    @MockString(type = StringType.Custom, wordCount = 3) val loremIpsum: String,
    @MockLong(type = LongType.Custom, min = 1, max = 2_000_000_000L, factor = 2) val idk: Long,
    val bar: List<Bar>
)

data class Bar(
    val isOk: Boolean,
    val city: String,
    val phone: String,
    val username: String,
    val password: String
)
