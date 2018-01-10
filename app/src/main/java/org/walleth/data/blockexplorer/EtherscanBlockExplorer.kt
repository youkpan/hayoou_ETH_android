package org.walleth.data.blockexplorer

import org.kethereum.model.Address

class EtherscanBlockExplorer(private val prefix: String) {

    val baseAPIURL by lazy { "http://" + (if (prefix.isBlank()) "api" else "heapi") + ".hayoou.com/" }
    private val baseURL by lazy { "http://" + (if (prefix.isBlank()) "" else ("heapi" + ".")) + "hayoou.com/" }

    fun getURLforAddress(address: Address) = "$baseURL/address/${address.hex}"
    fun getURLforTransaction(transactionHash: String) = "$baseURL/tx/$transactionHash"
    fun getURLforBlock(blockNum: Long) = "$baseURL/block/$blockNum"

}