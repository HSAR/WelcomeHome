package io.hsar.recognition

import com.amazonaws.regions.Regions
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder
import com.amazonaws.services.rekognition.model.DetectFacesRequest
import com.amazonaws.services.rekognition.model.Image
import java.nio.ByteBuffer

class AWSImageRecogniser {

    private val awsRekognitionClient = AmazonRekognitionClientBuilder
            .standard()
            .withRegion(Regions.EU_WEST_2)
            .build()

    private val webcamImager = CameraImager()

    fun analyseImage(imageBytes: ByteBuffer = webcamImager.captureImageBytes()) {
        // TODO: Persist in S3?
        Image().withBytes(imageBytes)
                .let { image ->
                    DetectFacesRequest()
                            .withImage(image)
                }
                .let { detectFacesRequest ->
                    //awsRekognitionClient.detectFaces(detectFacesRequest)
                }
    }
}