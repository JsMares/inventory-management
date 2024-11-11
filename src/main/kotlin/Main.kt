fun main(args: Array<String>) {
    mainProgram()
}

fun showMenu() {
    val options = listOf(
        "1. Show available products",
        "2. Add a new product to the inventory",
        "3. View shopping cart",
        "4. Finish shopping",
        "5. View shopping cart details",
        "6. Exit"
    )

    options.forEach { println(it) }
}

fun mainProgram() {
    val inventory = Inventory()

    var show = true

    while (show) {
        showMenu()

        print("Choose an option: ")
        val userInput = readln().toIntOrNull() ?: 0

        when (userInput) {
            1 -> { println("Show products") }
            2 -> {
                println("Add a new product".uppercase())
                inventory.registerProduct()
            }
            3 -> { println("View shopping cart") }
            4 -> { println("Finish shopping") }
            5 -> { println("View shopping cart details") }
            6 -> {
                println("Good bye!")
                show = false
            }
        }

        if (show) {
            print("\nWould you like to choose another option? YES / NO ")
            val continueInput = readln().trim().uppercase()
            show = continueInput == "YES"
        }
    }
}