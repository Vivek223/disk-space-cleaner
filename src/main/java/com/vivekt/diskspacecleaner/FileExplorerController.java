package com.vivekt.diskspacecleaner;

import com.vivekt.diskspacecleaner.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileExplorerController {

    private final FileService fileService;

    public FileExplorerController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping("/list")
    public List<String> listFiles(@RequestParam String path){
        path = "d:/2024/tmp";
        List<String> fileList = fileService.listFilesInDirectory(path);

        return fileList;
    }
}
