package co.istad.mobilebankingcstad.features.files;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    String uploadSingleFile(MultipartFile file);
    List<String> uploadMultipleFiles(MultipartFile[] files);
    void deleteFile(String filename);
}
