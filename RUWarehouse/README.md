Refer to the Warehouse file


The code implements a warehouse data structure using a hash table-like structure, where each entry of the table stores a priority queue (implemented in the Sector class). The warehouse can add, restock, delete, and purchase products. The warehouse is designed to handle products with limited space, and it evicts less popular products to maintain a constant size.

Let's go through the main methods in the Warehouse class:

addProduct(int id, String name, int stock, int day, int demand): Adds a new product to the warehouse. It first checks if the sector is at its maximum size (5 products). If so, it evicts the least popular item. Then, it adds the new product to the end of the sector and fixes the heap structure.

addToEnd(int id, String name, int stock, int day, int demand): Adds a new product to the end of the correct sector using the add() method of the Sector class.

fixHeap(int id): Fixes the heap structure of the sector after a new product is added, using the swim() and getSize() methods of the Sector class.

evictIfNeeded(int id): Deletes the least popular item in the correct sector if its size is 5, to maintain the heap structure. It uses swap(), deleteLast(), and sink() methods from the Sector class.

restockProduct(int id, int amount): Updates the stock of a product by the given amount. It searches for the product in the sector and updates its stock using the updateStock() method from the Product class.

deleteProduct(int id): Deletes a product from the warehouse while maintaining the heap structure. It searches for the product in the sector, swaps it with the last item, deletes the last item, and then sinks or swims the product to restore the heap structure.

purchaseProduct(int id, int day, int amount): Simulates a purchase order for a product. It searches for the product in the sector, updates its stock, demand, and last purchase day, and then restores the heap structure using sink().

betterAddProduct(int id, String name, int stock, int day, int demand): A modified version of addProduct() that checks for available space in the sector. If the sector has space, it adds the product to the sector and fixes the heap structure using swim(). Otherwise, it calls the regular addProduct() method to handle eviction.

The Warehouse class also includes a toString() method to print the string representation of the warehouse.

In summary, this code provides a way to manage products in a warehouse efficiently using a hash table-like structure with priority queues (min-heaps). It automatically evicts less popular products when the sector reaches its maximum capacity.

