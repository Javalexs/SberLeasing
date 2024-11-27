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

    public static Stream<Arguments> providerParametersCreateTest() {
        return Stream.of(
                Arguments.of(235298766, "Шариков", "Полиграф", "Полиграфович", "СобачьеСердце", "Преображенский", "8800352309872345", 7345 )
        );
    }

    public static Stream<Arguments> providerParametersUpdateTest() {
        return Stream.of(
                Arguments.of(235298766, "Шариков", "Иван", "Арнольдович", "СобачьеСердце", "Преображенский", "8800352309872345", 7345 )
        );
    }

    public static Stream<Arguments> providerParametersUserName() {
        return Stream.of(
                Arguments.of("Шариков")
        );
    }

}
