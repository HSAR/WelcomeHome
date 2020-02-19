package io.hsar.greeting

import com.amazonaws.regions.Regions
import com.amazonaws.services.polly.AmazonPollyClientBuilder
import com.amazonaws.services.polly.model.OutputFormat
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest
import com.amazonaws.services.polly.model.VoiceId.Amy
import com.amazonaws.services.polly.model.VoiceId.Brian
import com.amazonaws.services.polly.model.VoiceId.Emma
import javazoom.jl.player.FactoryRegistry
import javazoom.jl.player.advanced.AdvancedPlayer
import javax.sound.sampled.AudioFormat


class AWSAudioGreeter : Greeter {

    companion object {
        private val VOICE_F_AMY = Amy
        private val VOICE_F_EMMA = Emma
        private val VOICE_M_BRIAN = Brian

        private val AUDIO_FORMAT = AudioFormat(8000F, 16, 1, true, false)
    }

    private val awsPollyClient = AmazonPollyClientBuilder.standard().withRegion(Regions.EU_WEST_2).build()

    override fun sendGreeting(greeting: String) {
        SynthesizeSpeechRequest()
                .withEngine("standard")
                .withVoiceId(VOICE_F_AMY)
                .withOutputFormat(OutputFormat.Mp3)
                .withText(greeting)
                .let { request ->
                    awsPollyClient.synthesizeSpeech(request)
                }
                .audioStream
                .let { audioStream ->
                    // Add buffer for mark/reset support
                    AdvancedPlayer(audioStream, FactoryRegistry.systemRegistry().createAudioDevice())
                            .play()
                }
    }
}