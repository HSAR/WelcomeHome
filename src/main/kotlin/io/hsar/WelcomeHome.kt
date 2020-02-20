package io.hsar

import io.hsar.greeting.AWSAudioGreeter
import io.hsar.recognition.AWSImageRecogniser

class WelcomeHome {

}

fun main(args: Array<String>) {
    //AWSAudioGreeter().sendGreeting("Hello Sam")
    AWSImageRecogniser().analyseImage()
}