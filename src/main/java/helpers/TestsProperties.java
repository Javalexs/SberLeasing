package helpers;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "system:env",
        "file:src/test/resources/tests.properties"
})
public interface TestsProperties extends Config {

    /**
     * Поле для получения значения по ключу из tests.properties файла
     * @author Алексей Фадеев
     */
    @Key("google.url")
    String googleUrl();
}