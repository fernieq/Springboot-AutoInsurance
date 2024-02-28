package com.synergisticit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentId;
	
	@Lob
    private byte[] driverLicense;
	
	private String fileType;
	private String downloadURL;
	private Long byteSize;
    private String fileName;
    @ManyToOne
	private User user;    

    public  Document () {
    	super();
	}

    
	public Document(String fileName, String fileType, byte[] driverLicense, Long byteSize, String downloadURL, User user) {
		super();
		this.driverLicense = driverLicense;
		this.fileType = fileType;
		this.byteSize = byteSize;
		this.downloadURL = downloadURL;
		this.fileName = fileName;
		this.user = user;
	}


	public Document(String fileName, String fileType, byte[] driverLicense) {
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


	
    public Long getByteSize() {
		return byteSize;
	}


	public void setByteSize(Long byteSize) {
		this.byteSize = byteSize;
	}


	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public Long getDocumentId() {
		return documentId;
	}


	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
