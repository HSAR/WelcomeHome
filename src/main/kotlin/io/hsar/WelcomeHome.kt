package io.hsar

import io.hsar.greeting.AWSAudioGreeter

class WelcomeHome {

}

fun main(args: Array<String>) {
    AWSAudioGreeter().sendGreeting("Hello Sam")
}