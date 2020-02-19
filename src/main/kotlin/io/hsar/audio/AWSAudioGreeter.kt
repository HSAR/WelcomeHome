package io.hsar.audio

import com.amazonaws.services.polly.AmazonPollyClientBuilder
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest
import com.amazonaws.services.polly.model.VoiceId.Amy
import com.amazonaws.services.polly.model.VoiceId.Brian
import com.amazonaws.services.polly.model.VoiceId.Emma
import java.io.InputStream

class AWSAudioGreeter {

    companion object {
        private val VOICE_F_AMY = Amy
        private val VOICE_F_EMMA = Emma
        private val VOICE_M_BRIAN = Brian
    }

    private val awsPollyClient = AmazonPollyClientBuilder.standard().build()

    fun sendGreeting(greeting: String): InputStream {
        return SynthesizeSpeechRequest()
                .withEngine("standard")
                .withVoiceId(VOICE_F_AMY)
                .withText(greeting)
                .let { request ->
                    awsPollyClient.synthesizeSpeech(request)
                }
                .audioStream
    }
}