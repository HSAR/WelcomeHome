package io.hsar.recognition

import org.openimaj.video.capture.VideoCapture
import org.slf4j.LoggerFactory
import java.nio.ByteBuffer

class CameraImager {

    companion object {
        private val logger = LoggerFactory.getLogger(CameraImager::class.java)
    }

    fun captureImageBytes(): ByteBuffer {
        return VideoCapture(640, 480)
                .also { videoCapture ->
                    videoCapture.stopCapture()
                }
                .nextFrame
                .toByteImage()
                .let { byteArray ->
                    ByteBuffer.wrap(byteArray)
                }
                .also { imageBytes ->
                    logger.info("Image captured: ${imageBytes.position()}")
                }
    }
}