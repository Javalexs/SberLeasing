package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Класс с параметрами
 */
public class DataProvider {

    public static Stream<Arguments> providerParameters() {
        return Stream.of(
                Arguments.of("СберЛизинг", "Сбербанк Лизинг", "передний", "бензин", "автомат", "универсал", "белый")
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

    public static Stream<Arguments> providerParametersDeleteTest() {
        return Stream.of(
                Arguments.of("Шариков")
        );
    }
}
