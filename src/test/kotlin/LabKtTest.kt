import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import ru.tinkoff.lab11_2_3.main
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class LabKtTest {

    val testStreams = listOf(
        Pair(
        """2 8
0 0
0 0
0 0
1 0
1 0
1 1
1 2
1 3""", "0\r\n0\r\n0\r\n1\r\n1\r\n1\r\n2\r\n-1"),
        Pair(
            """3 6
0 7
0 0
2 0
3 3
4 0
5 0
""", "0\r\n7\r\n7\r\n-1\r\n-1\r\n-1")
    )



    @org.junit.jupiter.api.BeforeEach
    fun setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {

    }

    @Test
    fun testMain1() {
        var outContent = ByteArrayOutputStream()
        var `in` = ByteArrayInputStream(testStreams[1].first.toByteArray())
        System.setIn(`in`)
        System.setOut(PrintStream(outContent))
        main()
        assertEquals(testStreams[1].second, outContent.toString().trim())
    }
}