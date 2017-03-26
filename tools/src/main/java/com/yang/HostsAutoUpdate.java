package com.yang;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * this program just to update local hosts file every half hour
 */
public class HostsAutoUpdate
{
    private static final Logger logger= LoggerFactory.getLogger(HostsAutoUpdate.class);
    private static final File DESTINATION = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");

    public static void main(String[] args )  {
        String filePath = HostsAutoUpdate.class.getResource("").getPath()+"../../log4j.properties";
        PropertyConfigurator.configure(filePath);
        while (true){

            try {
                Thread.sleep(1000);
                updateFile();
                logger.info("update success!");
                Thread.sleep(1000*30*60);
            /*update every 0.5H */
//                Thread.sleep(1000*60*30);
            } catch (Exception e) {
                logger.error(e.toString());

            }
        }




    }

    private static void updateFile() throws IOException {
        URL url=new URL("https://raw.githubusercontent.com/LoveYoung/hosts/master/hosts");
        InputStream inputStream = url.openStream();
        if(DESTINATION.exists()){
            FileUtils.forceDelete(DESTINATION);
        }
        FileUtils.copyInputStreamToFile(inputStream, DESTINATION);
    }
}
