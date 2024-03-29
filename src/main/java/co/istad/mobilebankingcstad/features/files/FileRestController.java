package co.istad.mobilebankingcstad.features.files;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileRestController {
    private final FileService fileService;

    @PostMapping(value = "",consumes = "multipart/form-data")
    public String uploadSingleFile(@RequestPart("file")MultipartFile file){
        return fileService.uploadSingleFile(file);
    }

    @PostMapping(value = "/multiple",consumes = "multipart/form-data")
    public List<String> uploadMultipleFiles(@RequestPart("files") MultipartFile[] files){
        return fileService.uploadMultipleFiles(files);
    }

    @DeleteMapping("{fileName}")
    public String deleteFile(@PathVariable String fileName){
        fileService.deleteFile(fileName);
        return "file is deleted successfully!";
    }


}
