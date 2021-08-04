package datastructures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyHashMapTester {

    @Test
    fun `simple hashmap test`() {
        val myHashMap = MyHashMap<String, Int>(2)
        myHashMap.put("KaasPizza", 3)
        myHashMap.put("Kashmira", 8)
        myHashMap.put("Bob", 2)
        myHashMap.put("Gym", 1)

        assertEquals(myHashMap.get("KaasPizza"), 3)
        assertEquals(myHashMap.get("Kashmira"), 8)
        assertEquals(myHashMap.get("Bob"), 2)
        assertEquals(myHashMap.get("Gym"), 1)
        assertFailsWith(NoSuchElementException::class) {
            myHashMap.get("BlaBla")
        }
    }

    @Test
    fun `isEmpty works`() {
        val myHashMap1 = MyHashMap<String, Int>(0)
        val myHashMap2 = MyHashMap<String, Int>(2)
        assertTrue(myHashMap1.isEmpty())
        assertTrue(myHashMap2.isEmpty())

        myHashMap1.put("kaas", 1)
        myHashMap2.put("bla", 3)
        assertFalse(myHashMap1.isEmpty())
        assertFalse(myHashMap2.isEmpty())
    }

    @Test
    fun `resize is working`() {
        val myHashMap = MyHashMap<String, Int>(0)
        myHashMap.put("KaasPizza", 3)
        //0 >= floor(0.75 * 0) = 0
        assertEquals(myHashMap.getSize(), 1)
        assertEquals(myHashMap.getCapacity(), 1)

        //1 >= floor(0.75 * 1) = 0
        myHashMap.put("Kashmira", 8)
        assertEquals(myHashMap.getSize(), 2)
        assertEquals(myHashMap.getCapacity(), 3) //(1 shl 1) + 1

        //2 >= floor(0.75 * 3) = 2
        myHashMap.put("Bob", 2)
        assertEquals(myHashMap.getSize(), 3)
        assertEquals(myHashMap.getCapacity(), 7) //(3 shl 1) + 1

        //3 < floor (0.75 * 7) = 5
        myHashMap.put("Gym", 1)
        assertEquals(myHashMap.getSize(), 4)
        assertEquals(myHashMap.getCapacity(), 7) //unchanged


        //4 < floor (0.75 * 7) = 5
        myHashMap.put("Brood", 11)
        assertEquals(myHashMap.getSize(), 5)
        assertEquals(myHashMap.getCapacity(), 7) //unchanged

        //5 >= floor (0.75 * 7) = 5
        myHashMap.put("Berliner", 16)
        assertEquals(myHashMap.getSize(), 6)
        assertEquals(myHashMap.getCapacity(), 15) //(7 shl 1) + 1
    }

    @Test
    fun `containsKey works properly`() {
        val myHashMap = MyHashMap<Int, String>(20)
        assertFalse(myHashMap.containsKey(0))
        assertFalse(myHashMap.containsKey(20))
        assertFalse(myHashMap.containsKey(40))
        assertFalse(myHashMap.containsKey(60))
        assertFalse(myHashMap.containsKey(80))

        myHashMap.put(0, "kaas")
        myHashMap.put(20, "kaasPizza")
        myHashMap.put(40, "kaasHuis")
        myHashMap.put(60, "kaasAppartement")
        myHashMap.put(80, "kaasFlat")

        assertTrue(myHashMap.containsKey(0))
        assertTrue(myHashMap.containsKey(20))
        assertTrue(myHashMap.containsKey(40))
        assertTrue(myHashMap.containsKey(60))
        assertTrue(myHashMap.containsKey(80))
    }

    @Test
    fun `getKeys works properly`() {
        val myHashMap = MyHashMap<Int, String>(20)
        myHashMap.put(0, "kaas")
        myHashMap.put(20, "kaasPizza")
        myHashMap.put(40, "kaasHuis")
        myHashMap.put(60, "kaasAppartement")
        myHashMap.put(80, "kaasFlat")

        assertEquals(listOf(0, 20, 40, 60, 80), myHashMap.getKeys().sorted(), "keys incorrect")
    }

    @Test
    fun `getValues works properly`() {
        val myHashMap = MyHashMap<Int, String>(20)
        myHashMap.put(0, "kaas")
        myHashMap.put(20, "kaasPizza")
        myHashMap.put(40, "kaasHuis")
        myHashMap.put(60, "kaasAppartement")
        myHashMap.put(80, "kaasFlat")

        assertEquals(listOf("kaas", "kaasAppartement", "kaasFlat", "kaasHuis", "kaasPizza"), myHashMap.getValues().sorted(), "values incorrect")
    }

    @Test
    fun `remove works properly`() {
        val myHashMap = MyHashMap<Int, String>(20)
        myHashMap.put(0, "kaas")
        myHashMap.put(20, "kaasPizza")
        myHashMap.put(40, "kaasHuis")
        myHashMap.put(60, "kaasAppartement")
        myHashMap.put(80, "kaasFlat")
        assertEquals(myHashMap.getSize(), 5)
        assertTrue(myHashMap.containsKey(0))
        assertTrue(myHashMap.containsKey(20))
        assertTrue(myHashMap.containsKey(40))
        assertTrue(myHashMap.containsKey(60))
        assertTrue(myHashMap.containsKey(80))


        myHashMap.remove(60)
        assertEquals(myHashMap.getSize(), 4)
        assertFalse(myHashMap.containsKey(60))

        myHashMap.remove(20)
        assertEquals(myHashMap.getSize(), 3)
        assertFalse(myHashMap.containsKey(20))

        myHashMap.remove(80)
        assertEquals(myHashMap.getSize(), 2)
        assertFalse(myHashMap.containsKey(80))

        assertTrue(myHashMap.containsKey(0))
        assertTrue(myHashMap.containsKey(40))
    }
}