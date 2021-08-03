package datastructures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MyHashMapTester {

    @Test
    fun `simple hashmap test`(){
        val myHashMap = MyHashMap<String, Int>(2)
        myHashMap.put("KaasPizza", 3)
        myHashMap.put("Kashmira", 8)
        myHashMap.put("Bob", 2)
        myHashMap.put("Gym", 1)

        assertEquals(myHashMap.get("KaasPizza"), 3)
        assertEquals(myHashMap.get("Kashmira"), 8)
        assertEquals(myHashMap.get("Bob"), 2)
        assertEquals(myHashMap.get("Gym"), 1)
        assertFailsWith(NoSuchElementException::class){
            myHashMap.get("BlaBla")
        }

    }
}