package com.novi.hexagon.controller;

import com.novi.hexagon.exceptions.BadRequestException;
import com.novi.hexagon.model.Demo;
import com.novi.hexagon.model.Producer;
import com.novi.hexagon.model.User;
import com.novi.hexagon.service.DemoService;
import com.novi.hexagon.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api/v1/")
public class DemoController {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    DemoService demoService;

    @PostMapping(value = "/demo-upload")
    public ResponseEntity<Object> addDemo(@RequestParam("username") String username,
                                          @RequestParam("artist") String artist,
                                          @RequestParam("feedback") String feedback,
                                          @RequestParam("comment") String comment,
                                          @RequestParam("file") MultipartFile file) {
        try {
            fileStorageService.uploadFile(file);
            Demo demo = new Demo();
            demo.setUsername(username);
            demo.setArtist(artist);
            demo.setFeedback(feedback);
            demo.setComment(comment);
            demo.setDemo(file.getOriginalFilename());

            demoService.addDemo(demo);

            System.out.println("FILE-NAME " + file.getOriginalFilename());
            System.out.println("ARTIST " + artist);
            System.out.println("FEEDBACK " + feedback);
            System.out.println("USERNAME " + username);



            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @GetMapping("demo/{filename}")
    public ResponseEntity<Object> getDemoByFilename(@PathVariable("filename") String filename){
        Optional<Demo> demo = this.demoService.getDemoByFilename(filename);
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @DeleteMapping(value = "demo/{filename}")
    public ResponseEntity<Object> deleteDemoByFilename(@PathVariable("filename") String filename) throws IOException {
        demoService.deleteDemo(filename);
        fileStorageService.deleteFile(filename);
        return ResponseEntity.noContent().build();
    }






}
