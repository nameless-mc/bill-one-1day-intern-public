package sender.domain.sender_invoice

data class SenderInvoiceMemo (
    val senderInvoiceUUID: SenderInvoiceUUID,
    val memo: String,
){
    init {
        require(memo.length <= 255){ "memo must be less than or equal to 255 characters"}
    }
}
