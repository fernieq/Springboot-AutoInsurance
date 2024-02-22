package com.synergisticit.domain;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documetnId;
	
	@Lob
    private byte[] driverLicense;
	
	private String fileType;

    private String fileName;
        
    public Document() {
    }

    
	public Document(String fileName,  String fileType, byte[] driverLicense) {
		super();
		this.driverLicense = driverLicense;
		this.fileType = fileType;
		this.fileName = fileName;
	}


	// Getters and Setters

	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public Long getDocumetnId() {
        return documetnId;
    }

    public void setDocumetnId(Long documetnId) {
        this.documetnId = documetnId;
    }

    public byte[] getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(byte[] driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
