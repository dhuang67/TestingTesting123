package com.example.testingtesting123

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        // Test 1: Add 1 item to collection and check the item
        assertEquals(0, collection.size()) //first check the size

        var item1 = Item("Item1")
        collection.addItem(item1)
        assertEquals(1, collection.size()) // check if item gets added
        assertEquals(item1, collection.get(0))

        // Test 2: Add multiple items
        var item2 = Item("Item2")
        var item3 = Item("Item3")
        collection.addItem(item2)
        collection.addItem(item3)
        assertEquals(3, collection.size()) // check if item gets added size should be 3
        assertEquals(item3, collection.get(2))
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        // Test 1: add multiple items with the same name
        val item1 = Item("Gadget")
        val item2 = Item("Gadget")
        val item3 = Item("Widget")

        collection.addItem(item1)
        collection.addItem(item2)
        collection.addItem(item3)

        assertEquals("Collection should only contain unique items based on name", 2, collection.size())
        assertEquals("The second unique item should be at index 1", item3, collection.get(1))
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}