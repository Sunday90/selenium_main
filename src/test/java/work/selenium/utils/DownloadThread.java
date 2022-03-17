package work.selenium.utils;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class DownloadThread implements Callable<HashMap<String, Long>> {
    private final String fileUrl;
    private final String wgetCommand;


    public DownloadThread (String fileUrl) {
        this.fileUrl = fileUrl;
        this.wgetCommand = System.getProperty("user.dir") + "\\src\\test\\resources\\wget.exe --no-check-certificate " + fileUrl;
    }

    @Override
    public HashMap<String, Long> call() throws Exception {
        Runtime.getRuntime().exec(wgetCommand);
        String[] url = fileUrl.split("/");
        File file = new File(System.getProperty("user.dir") + "\\" + url[url.length-1]);

        HashMap<String, Long> hashMap = new HashMap<>(1);
        hashMap.put(file.getName(), file.length());
        return hashMap;
    }
}
