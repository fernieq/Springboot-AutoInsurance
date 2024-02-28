package com.synergisticit.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "claim_images")
public class ClaimImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimImageId;

    private String fileType;
    private String filename;

    @Lob
    private byte[] data;

    private String downloadImageURL; 
    
    // Constructors

    public ClaimImage() {
    	super();
    }
    
    

	public ClaimImage(String filename, String fileType, byte[] data, String downloadImageURL) {
		super();
		this.filename = filename;
		this.fileType = fileType;
		this.data = data;
		this.downloadImageURL = downloadImageURL;
	}



	public Long getClaimImageId() {
		return claimImageId;
	}

	public void setClaimImageId(Long claimImageId) {
		this.claimImageId = claimImageId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	public String getFileType() {
		return fileType;
	}



	public void setFileType(String fileType) {
		this.fileType = fileType;
	}



	public String getDownloadImageURL() {
		return downloadImageURL;
	}

	public void setDownloadImageURL(String downloadImageURL) {
		this.downloadImageURL = downloadImageURL;
	}

    
   
}