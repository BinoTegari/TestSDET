package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigureService {
  private static final String FILE_PATH = "src/config.properties";
  private static ConfigureService instance;
  private Properties properties = new Properties();

  // запрещаем прямое создание объекта
  private ConfigureService() {
    this.loadProperties();
  }

  // получаем инстанс
  public static ConfigureService getInstance() {
    // метод статический поэтому используем ConfigureService.class
    synchronized (ConfigureService.class) {
      if (instance == null) {
        instance = new ConfigureService();
      }
      return instance;
    }
  }

  public Properties getProperties() {
    return properties;
  }

  private void loadProperties() {
    try {
      FileInputStream inputStream = new FileInputStream(FILE_PATH);
      this.properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
