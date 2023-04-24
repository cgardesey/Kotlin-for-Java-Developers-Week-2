package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPos = secret.zip(guess).count{it.first == it.second}
    val comLetters = "ABCDEF".sumBy { char ->
        secret.count { it == char }.coerceAtMost(guess.count { it == char })
    }
    return Evaluation(rightPos, comLetters - rightPos)
}
