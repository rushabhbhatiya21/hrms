package com.example.hrms.models.emploment_info;

import com.example.hrms.utils.ImageUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Entity
@Getter
@Setter
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    private String documentCategory;

    private String titleOfDocument;

    private String documentDescription;

    @Basic(fetch = FetchType.LAZY)
    @Column(length = 400000)
    private byte[] documentPhoto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;

    public void setDocumentPhoto(MultipartFile documentPhoto) {
        try {
            this.documentPhoto = ImageUtils.compressImage(documentPhoto.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    public void setDocumentPhoto(byte[] documentPhoto) {
//        try {
//            this.documentPhoto = documentPhoto;
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    public String getDocumentPhotoString() {
        return Base64.getEncoder().encodeToString(ImageUtils.decompressImage(documentPhoto));
    }
}
