package utils;
import java.time.Duration;

public final class Config{


    private Config(){

    }

    private static final int SECONDS=10;
    public static final Duration EXPLICIT_WAIT=Duration.ofSeconds(SECONDS);
}