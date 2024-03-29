package co.istad.mobilebankingcstad.features.files;

import co.istad.mobilebankingcstad.features.files.dto.FileResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
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

    //http://localhost:8888/api/v1/files/download/3f54df29-31f0-4c74-9552-62dfca9e4f1e.png
    private String generateImageUrl(HttpServletRequest request, String filename) {
        return String.format("%s://%s:%d/images/%s",
                request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                filename);
    }
    private String generateDownloadImageUrl(HttpServletRequest request, String filename) {
        return String.format("%s://%s:%d/api/v1/files/download/%s",
                request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                filename);
    }

    private String uploadFile(MultipartFile file) {
        try {
//       Check if the directory doesn't exist , we will create the directory
            Path fileStoragePath = Path.of(fileStorageDir);
            if (!Files.exists(fileStoragePath)) {
                Files.createDirectories(fileStoragePath);
            }
            String fileName = UUID.randomUUID() + "." +
                    Objects.requireNonNull(file.getOriginalFilename())
                            .split("\\.")[1];
            // handle if there are more than one dot !

            Files.copy(file.getInputStream(),
                    fileStoragePath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public FileResponse uploadSingleFile(MultipartFile file, HttpServletRequest request) {

        String filename = uploadFile(file);
        String fullImageUrl = generateImageUrl(request, filename);

        return FileResponse.builder()
                .downloadUrl(generateDownloadImageUrl(request,filename))
                .fileType(file.getContentType())
                .size((float) file.getSize() / 1024) // in KB
                .filename(filename)
                .fullUrl(fullImageUrl).build();
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
    public ResponseEntity<Resource> serveFile(String filename, HttpServletRequest request) {
        try {
            //        get path of the images
            Path imagePath = Path.of(fileStorageDir).resolve(filename);
            Resource resourceUrl = new UrlResource(imagePath.toUri());
            if(resourceUrl.exists()){
                return ResponseEntity
                        .ok()
                    .contentType(MediaType.parseMediaType("image/jpeg"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceUrl.getFilename() + "\"")
                    .body(resourceUrl);
            }else {
                // bad request
                throw new RuntimeException("Resources not found ! ");
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteFile(String filename) {

    }
}
