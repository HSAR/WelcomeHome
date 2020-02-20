package io.hsar.recognition

import com.github.sarxos.webcam.Webcam
import org.slf4j.LoggerFactory
import java.awt.image.BufferedImage
import java.nio.ByteBuffer

class CameraImager {

    companion object {
        private val logger = LoggerFactory.getLogger(CameraImager::class.java)
    }

    private val camera = Webcam.getDefault()
            .also { camera ->
                camera.open()
            }

    fun captureImage(): BufferedImage {
        return camera.image
    }

    fun captureImageBytes(): ByteBuffer {
        return camera.imageBytes
                .also { imageBytes ->
                    logger.info("Image captured: ${imageBytes.position()}")
                }
    }
}