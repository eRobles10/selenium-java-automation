package utils;
import java.time.Duration;

public final class Config{


    private Config(){  
    }

    private static String setUpEnvironment(){
        String envType = System.getProperty("env","qa");
        return switch(envType){
            case "qa"-> "https://www.saucedemo.com";
            case "staging"-> "https://staging.example.com/";
            default-> throw new IllegalArgumentException(
                                  "Ambiente no soportado: " + envType
                            );   
        };

    }

    private static final int SECONDS=10;
    public static final Duration EXPLICIT_WAIT=Duration.ofSeconds(SECONDS);
    public static final String PROJECT_URL =setUpEnvironment();
}