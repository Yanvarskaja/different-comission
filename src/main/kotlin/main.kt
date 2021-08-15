fun main() {
    val type = PaymentType.Visa
    val previousTransfer = 7_500_001
    val currentTransfer = 10_000_000
    fun calculateCommission(): Int {
        return when (type) {
            PaymentType.Maestro, PaymentType.MasterCard -> 0
            PaymentType.Visa, PaymentType.Mir -> (currentTransfer / 100 * 0.75).toInt()
            PaymentType.VkPay -> 0
        }
    }

    fun print() = run {
        if (previousTransfer > 7_500_000 && type == PaymentType.Maestro || previousTransfer > 7_500_000 && type == PaymentType.MasterCard) {
            var commision: Int = (currentTransfer / 100 * 0.6 + 20_000).toInt()
            println("Размер комиссии: " + (commision.toInt())/100 + " руб.")
        } else if (type == PaymentType.Mir || type == PaymentType.Visa) {
            var commision: Int = (currentTransfer / 100 * 0.75).toInt()
            if (commision < 3500) {
                commision = 3500
                println("Размер комиссии: " + (commision.toInt())/100 + " руб.")
            } else {
                println("Размер комисссии: " + (calculateCommission())/100 + " руб.")
            }
        } else {
            println("Размер комисссии: " + (calculateCommission())/100 + " руб.")
        }


    }
    println(print())

}

enum class PaymentType {
    MasterCard, Visa, Maestro, Mir, VkPay
}