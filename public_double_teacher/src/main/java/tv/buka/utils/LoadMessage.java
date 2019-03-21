package tv.buka.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class LoadMessage implements CommandLineRunner {
    public static Map<String,String> map=new HashMap<>();
    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/message.properties"));
            map=(Map) properties;
        } catch (IOException e) {
            map.put("error","is null");
        }
    }

}
