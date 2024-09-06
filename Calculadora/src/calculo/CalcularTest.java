package calculo;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.launcher.ApplicationLauncher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.swing.core.matcher.JTextComponentMatcher.withText;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AssertJSwingExtension.class)
public class CalcularTest {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        ApplicationLauncher.launch(Calcular.class);
        window = new FrameFixture(findFrame(Calcular.class));
        window.show(); // mostra a janela
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp(); // limpa os recursos
    }

    @Test
    @GUITest
    public void testAddition() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("5");
        textField2.enterText("3");
        JButtonFixture sumButton = window.button(withText("Somar"));
        sumButton.click();

        resultField.requireText("8.0");
    }

    @Test
    @GUITest
    public void testSubtraction() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("10");
        textField2.enterText("4");
        JButtonFixture subtractButton = window.button(withText("Subtrair"));
        subtractButton.click();

        resultField.requireText("6.0");
    }

    @Test
    @GUITest
    public void testMultiplication() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("7");
        textField2.enterText("6");
        JButtonFixture multiplyButton = window.button(withText("Multiplicar"));
        multiplyButton.click();

        resultField.requireText("42.0");
    }

    @Test
    @GUITest
    public void testDivision() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("12");
        textField2.enterText("4");
        JButtonFixture divideButton = window.button(withText("Dividir"));
        divideButton.click();

        resultField.requireText("3.0");
    }

    @Test
    @GUITest
    public void testDivisionByZero() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("10");
        textField2.enterText("0");
        JButtonFixture divideButton = window.button(withText("Dividir"));
        divideButton.click();

        resultField.requireText("Divisão por zero não é permitida.");
    }

    @Test
    @GUITest
    public void testInvalidInput() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("abc");
        textField2.enterText("xyz");
        JButtonFixture sumButton = window.button(withText("Somar"));
        sumButton.click();

        resultField.requireText("Entrada inválida");
    }

    @Test
    @GUITest
    public void testClear() {
        JTextComponentFixture textField1 = window.textBox("textField1");
        JTextComponentFixture textField2 = window.textBox("textField2");
        JTextComponentFixture resultField = window.textBox("textFieldResult");

        textField1.enterText("9");
        textField2.enterText("5");
        JButtonFixture sumButton = window.button(withText("Somar"));
        sumButton.click();

        JTextComponentFixture clearButton = window.button(withText("Limpar"));
        clearButton.click();

        textField1.requireText("");
        textField2.requireText("");
        resultField.requireText("");
    }
}
