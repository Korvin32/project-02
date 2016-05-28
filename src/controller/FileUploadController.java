package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@SessionScoped
public class FileUploadController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);
    
    private static final String UPLOAD_DIRECTORY_LOCATION = "E:/tmp/_upload";
    
    public void fileUploadHandler(FileUploadEvent event) {
        UploadedFile uFile = event.getFile();
        String uFileName = uFile.getFileName();
        LOG.info("--- fileUploadHandler(): upload file name is '{}'", uFileName);
        try {
            InputStream iStrem = uFile.getInputstream();
            
            Path newFile = Paths.get(UPLOAD_DIRECTORY_LOCATION, uFileName);
            
            Files.copy(iStrem, newFile, StandardCopyOption.REPLACE_EXISTING);
            
            FacesMessage message = new FacesMessage("Succesful", uFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            iStrem.close();
        } catch (IOException e) {
            LOG.error("Error: " + e.getMessage(), e);
        }
        LOG.info("--- fileUploadHandler(): upload file done!");
    }
}
