package io.hsar.recognition

import org.opencv.core.Mat
import org.opencv.videoio.VideoCapture
import org.slf4j.LoggerFactory
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.nio.ByteBuffer


class CameraImager {

    companion object {
        private val logger = LoggerFactory.getLogger(CameraImager::class.java)
    }

    private val camera = VideoCapture(0)

    fun captureImageBytes(): ByteBuffer {
        return Mat()
                .also { matrix ->
                    camera.read(matrix)
                }
                .let { matrix ->
                    (BufferedImage(matrix.width(),
                            matrix.height(), BufferedImage.TYPE_3BYTE_BGR)
                            .raster.dataBuffer as DataBufferByte).data
                }
                .let { byteArray ->
                    ByteBuffer.wrap(byteArray)
                }
                .also { imageBytes ->
                    logger.info("Image captured: ${imageBytes.position()}")
                }
    }
}