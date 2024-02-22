package com.example.hrms.models.emploment_info;

import com.example.hrms.utils.ImageUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "photograph")
public class Photograph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photographId;

    @Basic(fetch = FetchType.LAZY)
    @Column(length = 400000)
    private byte[] employeePhoto;

    @Basic(fetch = FetchType.LAZY)
    @Column(length = 400000)
    private byte[] employeeSign;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;

    public void setEmployeePhoto(MultipartFile empPhoto) {
        try {
            this.employeePhoto = ImageUtils.compressImage(empPhoto.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setEmployeeSign(MultipartFile empSign) {
        try {
            this.employeePhoto = ImageUtils.compressImage(empSign.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmployeePhotoString() {
        return Base64.getEncoder().encodeToString(ImageUtils.decompressImage(employeePhoto));
    }
    public String getEmployeeSignString() {
        return Base64.getEncoder().encodeToString(ImageUtils.decompressImage(employeeSign));
    }
}
