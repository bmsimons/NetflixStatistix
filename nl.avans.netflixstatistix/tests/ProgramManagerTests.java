import logic.ProgramManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProgramManagerTests {
    @Test
    void checkIfProgramManagerIsNotNull() {
        ProgramManager programManager = new ProgramManager();

        if (programManager == null) {
            Assertions.assertTrue(false);
        } else {
            Assertions.assertTrue(true);
        }
    }

}
