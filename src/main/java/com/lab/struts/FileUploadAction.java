package com.lab.struts;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import org.apache.commons.io.*;
import org.apache.struts2.convention.annotation.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Action("/fileupload")
@Result(name = "success", location = "/results.jsp")
public class FileUploadAction extends ActionSupport {
  private static final Logger logger = LogManager.getLogger(FileUploadAction.class);

  private File uploadedFile;
  private String uploadedFileName;
  private String localDirectory = "uploads";

  public void setUploadedFile(File file) {
    uploadedFile = file;
  }

  public void setUploadedFileFileName(String name) {
    uploadedFileName = name;
  }

  public String execute() throws Exception {
    logger.info("Upload action started");
    try {
      File localFile = new File(localDirectory, uploadedFileName);
      FileUtils.copyFile(uploadedFile, localFile);
      logger.info("File uploaded successfully: {}", localFile.getAbsolutePath());
    } catch (Exception e) {
      logger.error("Upload failed", e);
    }
    return SUCCESS;
  }

  /* Used to obtain a file listing for JSP display. */
  public Set<String> getFileList() {
    return Stream.of(new File(localDirectory).listFiles())
      .filter(file -> !file.isDirectory())
      .map(File::getName)
      .collect(Collectors.toSet());
  }

}