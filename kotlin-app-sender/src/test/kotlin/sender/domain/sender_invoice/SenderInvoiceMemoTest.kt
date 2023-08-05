package sender.domain.sender_invoice

import org.assertj.core.api.Assertions
import org.junit.Test
import java.util.UUID
import kotlin.IllegalArgumentException

class SenderInvoiceMemoTest{
    @Test
    fun testConstructor(){
        val uuid = SenderInvoiceUUID(UUID.randomUUID())
        val validMemoStr = "a".repeat(255)
        val invalidMemoStr = "a".repeat(256)
        Assertions.assertThat(SenderInvoiceMemo(uuid, validMemoStr).memo).isEqualTo(validMemoStr)
        Assertions.assertThatThrownBy { SenderInvoiceMemo(uuid, invalidMemoStr) }.isInstanceOfSatisfying(IllegalArgumentException::class.java){
            Assertions.assertThat(it.message).contains("memo must be less than or equal to 255 characters")
        }
    }
}