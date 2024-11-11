class Inventory() {

    private val stock: MutableList<Product> = mutableListOf<Product>()

    fun registerProduct() {
        println("Please type the following information...")

        print("Product name: ")
        val name = readln()

        print("Product price: ")
        val price = readln().toDouble()

        print("Quantity available of the product on stock: ")
        val quantity = readln().toInt()
        val categories = Category.values()
        categories.forEach { println(it.name) }

        print("Choose a category: ")
        val categoryInput = readln().uppercase().trim()
        /*val category = when(readln()) {
            Category.ELECTRONICS.toString() -> Category.ELECTRONICS
            Category.HOME.toString() -> Category.HOME
            Category.FOOD.toString() -> Category.FOOD
            Category.CLOTHING.toString() -> Category.CLOTHING
            Category.TOYS.toString() -> Category.TOYS
            Category.HEALTH.toString() -> Category.HEALTH
            Category.OFFICE.toString() -> Category.OFFICE
            Category.TOOLS.toString() -> Category.TOOLS
            Category.OTHERS.toString() -> Category.OTHERS
            else -> {
                println("Invalid category. Please try again.")
                return
            }
        }*/

        val category = categories.find { category -> category.name == categoryInput }
        if (category == null) {
            println("Invalid category. Please try again.")
            return
        }

        val exitingProduct = stock.find { product -> product.name == name }
        if (exitingProduct == null) {
            stock.add(Product(name = name, price = price, stock = quantity, category = category))
            println("Product $name has been registered successfully!")
        }
        else
            println("Product $name has already been registered")
    }

    fun getProducts(): List<Product> {
        return stock
    }
}