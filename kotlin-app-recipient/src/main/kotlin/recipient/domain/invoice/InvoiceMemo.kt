package recipient.domain.invoice

data class InvoiceMemo (
    val invoiceUUID: InvoiceUUID,
    val memo: String,
){
    init {
        require(memo.length <= 255){ "memo must be less than or equal to 255 characters"}
    }
}

