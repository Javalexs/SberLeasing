package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {
    /**
     * Метод для передачи параметров в тест
     * @author Алексей Фадеев
     */
    public static Stream<Arguments> providerParameters() {
        return Stream.of(
                Arguments.of("передний", "бензин", "автомат", "универсал", "белый")
        );
    }
}
