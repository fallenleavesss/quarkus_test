package com.github.demo.resource;

import java.nio.file.Files;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;

@Path("file")
public class FileEndpoint {

    @POST
    @Path("file-upload")
    public void fileUpload(@RestForm FileUpload fileUpload) throws WebApplicationException {
        // 检查是否上传了文件
        if (fileUpload == null) {
            throw new WebApplicationException("No file uploaded", 400);
        }

        // 文件名
        String file_name = fileUpload.fileName();
        // 保存目标地址
        java.nio.file.Path file_Path = java.nio.file.Path.of("C:\\Users\\Administrator\\Desktop\\files\\" + file_name);

        try {
            Files.deleteIfExists(file_Path);
            if (fileUpload.uploadedFile().toFile().renameTo(file_Path.toFile())) {
                throw new WebApplicationException(
                        "Unable to save file ", 400);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
