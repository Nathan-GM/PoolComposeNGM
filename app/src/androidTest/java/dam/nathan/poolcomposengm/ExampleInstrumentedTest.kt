package dam.nathan.poolcomposengm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import dam.nathan.poolcomposengm.ui.theme.PoolComposeNGMTheme

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun textFieldTest() {
        rule.setContent {
            PoolComposeNGMTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Formulario(Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }

        rule.onNodeWithText("Metros cúbicos").assertExists()
        rule.onNodeWithText("Lectura de PH").assertExists()
        rule.onNodeWithText("Gramos m³").assertExists()
        rule.onNodeWithText("Debes rellenar todos los datos").assertExists()

    }

    @Test
    fun resultadoCorrecto() {
        rule.setContent {
            PoolComposeNGMTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Formulario(Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }
        val m3 = rule.onNodeWithText("Metros cúbicos")
        val ph = rule.onNodeWithText("Lectura de PH")
        val gramos = rule.onNodeWithText("Gramos m³")
        val result = rule.onNodeWithTag("result")

        m3.performTextInput("43")
        ph.performTextInput("7.0")
        gramos.performTextInput("5")

        val resultado = (7.4 - 7.0) * 10 * 43* 5

        result.assertTextEquals(resultado.toString())

    }

    @Test
    fun resultadoNegativoCorrecto() {
        rule.setContent {
            PoolComposeNGMTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Formulario(Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }
        val m3 = rule.onNodeWithText("Metros cúbicos")
        val ph = rule.onNodeWithText("Lectura de PH")
        val gramos = rule.onNodeWithText("Gramos m³")
        val result = rule.onNodeWithTag("result")

        m3.performTextInput("43")
        ph.performTextInput("7.5")
        gramos.performTextInput("5")

        val resultado = (7.4 - 7.5) * 10 * 43 * 5

        result.assertTextEquals(resultado.toString())
    }
}
