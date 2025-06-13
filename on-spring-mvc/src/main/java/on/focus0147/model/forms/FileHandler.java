package on.focus0147.model.forms;

import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;

import java.io.IOException;

public class FileHandler {
    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);

    private FileHandler(){}

    public static byte[] getPhotoByte(MultipartFile photo){
        byte[] b = null;
        try {
            b = IOUtils.toByteArray(photo.getInputStream());
        } catch (IOException e) {
            logger.error("Error reading file", e);
        }
        return (b!= null && b.length > 0) ? b : null;
    }
}
