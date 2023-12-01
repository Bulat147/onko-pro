package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.onko.exceptions.QrCodeGenerationException;
import ru.onko.model.jooq.tables.pojos.AccessHashEntity;
import ru.onko.repository.jooq.AccessHashRepository;
import ru.onko.services.AccessLinkGeneratingService;
import ru.onko.services.impl.utils.QrCodeGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessLinkGeneratingServiceImpl implements AccessLinkGeneratingService {

    private final AccessHashRepository accessHashRepository;

    private final Integer expiresDays = 2;

    @Value("${app.netlink}")
    private String netlink;

    @Override
    public String generateAccessLink(UUID userId) {
        AccessHashEntity accessHash = AccessHashEntity.builder()
                .userId(userId)
                .expiresDate(LocalDateTime.now().plusDays(expiresDays))
                .build();
        UUID hash = accessHashRepository.save(accessHash);
        return netlink + "/" + "note/link/" + hash;
    }

    @Override
    public byte[] generateAccessQrCode(UUID userId){
        BufferedImage bufferedImage;
        try {
            bufferedImage = QrCodeGenerator.generateQRCodeImage(generateAccessLink(userId));
        } catch (Exception e) {
            throw new QrCodeGenerationException("Не удалось сгенерировать qr-код");
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }
}
