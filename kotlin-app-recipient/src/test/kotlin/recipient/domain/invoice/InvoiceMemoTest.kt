package recipient.domain.invoice

import org.assertj.core.api.Assertions
import org.junit.Test
import java.util.*

class InvoiceMemoTest{
    @Test
    fun testConstructor(){
        val uuid = InvoiceUUID(UUID.randomUUID())
        val validMemoStr = "a".repeat(255)
        val invalidMemoStr = "a".repeat(256)
        Assertions.assertThat(InvoiceMemo(uuid, validMemoStr).memo).isEqualTo(validMemoStr)
        Assertions.assertThatThrownBy { InvoiceMemo(uuid, invalidMemoStr) }.isInstanceOfSatisfying(IllegalArgumentException::class.java){
            Assertions.assertThat(it.message).contains("memo must be less than or equal to 255 characters")
        }
    }
}
