package co.istad.mobilebankingcstad.features.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class FileServiceImpl implements FileService {
    @Value("${file.storage-dir}")
    String fileStorageDir;

    private String uploadFile(MultipartFile file)  {
        try {
//       Check if the directory doesn't exist , we will create the directory
            Path fileStoragePath = Path.of(fileStorageDir);
            if (!Files.exists(fileStoragePath)) {
                Files.createDirectories(fileStoragePath);
            }
            String fileName = UUID.randomUUID() + "." +
                    Objects.requireNonNull(file.getOriginalFilename())
                            .split("\\.")[1];

            Files.copy(file.getInputStream(),
                    fileStoragePath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

    }


    @Override
    public String uploadSingleFile(MultipartFile file) {
        return uploadFile(file);
    }

    @Override
    public List<String> uploadMultipleFiles(MultipartFile[] files) {
        var fileNames = new ArrayList<String>();
        for (var file : files) {
            fileNames.add(uploadFile(file));
        }
        return fileNames;
    }

    @Override
    public void deleteFile(String filename) {

    }
}
