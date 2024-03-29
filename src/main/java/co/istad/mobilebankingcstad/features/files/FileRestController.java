package co.istad.mobilebankingcstad.features.files;


import co.istad.mobilebankingcstad.features.files.dto.FileResponse;
import co.istad.mobilebankingcstad.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileRestController {
    private final FileService fileService;

    @PostMapping(value = "",consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<FileResponse> uploadSingleFile(
            @RequestPart("file")MultipartFile file
    ){
        return BaseResponse
                .<FileResponse>createSuccess()
                .setPayload(
                        new FileResponse(
                                fileService.uploadSingleFile(file)
                                ,"")
                );
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
