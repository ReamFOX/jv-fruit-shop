package service;

import java.util.List;

public interface WriterService {
    void writeToFile(List<String> data, String pathToFile);
}
