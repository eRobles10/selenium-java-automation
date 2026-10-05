package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.function.Supplier;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotExtension implements TestWatcher {

    private final Supplier<WebDriver> driverSupplier;
    private final String path;

    public ScreenshotExtension(Supplier<WebDriver> driverSupplier, String path) {
        this.driverSupplier = driverSupplier;
        this.path = path;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {

            WebDriver driver = this.driverSupplier.get();
             if (driver == null) return;
            new File(path).mkdirs();
            LocalDateTime now= LocalDateTime.now();
            DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String date=now.format(dateFormat);
            String displayName = context.getDisplayName();
            String name = context.getRequiredTestClass().getSimpleName()+"_"+
                            context.getRequiredTestMethod().getName(); 
            if(displayName.startsWith("[")){
                int index = Integer.parseInt(
                   displayName.substring(displayName.indexOf('[') + 1, displayName.indexOf(']'))
                );
                name+="_"+index+ "_" +date; 
            }else{
                name+= "_" +date; 
            }
            System.out.println("TEST FAILED");
            System.out.println("Class: "+context.getRequiredTestClass().getSimpleName());
            System.out.println("Method: "+context.getRequiredTestMethod().getName());
            System.out.println("Display name: "+context.getDisplayName()); 
            try (FileOutputStream out = new FileOutputStream(path + "/" + name + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (Exception e) {
            System.out.println("No se pudo capturar screenshot: " + e.getMessage());
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) { }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) { }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) { }
}