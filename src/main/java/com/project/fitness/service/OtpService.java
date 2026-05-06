package com.project.fitness.service;

import com.project.fitness.model.Otp;
import com.project.fitness.repository.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;

    public String generateOtp() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    public void sendOtp(String email) {

        String otp = generateOtp();

        Otp otpEntity = otpRepository.findByEmail(email)
                .orElse(new Otp());

        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);

        otpRepository.save(otpEntity);

        //  IMPORTANT (console OTP)
        System.out.println("Generated OTP for " + email + " is: " + otp);
    }

    public boolean verifyOtp(String email, String otp) {

        Otp otpEntity = otpRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("OTP not found"));

        if (otpEntity.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        if (!otpEntity.getOtp().equals(otp)) {
            return false;
        }

        otpEntity.setVerified(true);
        otpRepository.save(otpEntity);

        return true;
    }

    public boolean isOtpVerified(String email) {
        Otp otp = otpRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("OTP not found"));

        return otp.isVerified();
    }

    public void deleteOtp(String email) {
        otpRepository.findByEmail(email).ifPresent(otpRepository::delete);
    }
}