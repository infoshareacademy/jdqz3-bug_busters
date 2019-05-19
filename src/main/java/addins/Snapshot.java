package addins;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Snapshot {

    private final WebDriver driver;
    private final String baseDir;

    public Snapshot(WebDriver driver, String baseDir) {
        this.driver = driver;
        this.baseDir = baseDir;
    }

    public void takeSnapshot(String filename) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(filePath(filename + ' ' + date));
        FileUtils.copyFile(source, destination);
    }

    private String filePath(String filename) {
        return String.format("%s%s%s.png", baseDir, File.separator, filename);
    }

}

