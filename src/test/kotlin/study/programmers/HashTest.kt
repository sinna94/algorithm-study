package study.programmers

import study.programmers.hash.BestAlbum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HashTest {
    @Test
    fun testBestAlbum() {
        val result = BestAlbum().solution(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
        )
        val expected = intArrayOf(4, 1, 3, 0)
        assertEquals(expected.count(), result.count())
        result.forEachIndexed { index, r ->
            assertEquals(expected[index], r)
        }
    }
}
