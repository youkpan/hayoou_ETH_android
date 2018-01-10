package org.walleth.data.networks

import org.kethereum.ETHEREUM_NETWORK_RINKEBY
import org.kethereum.model.ChainDefinition

val RINKEBY_CHAIN_ID = 5767778797L

class RinkebyNetworkDefinition : BaseNetworkDefinition() {

    override val etherscanPrefix = "hayoou"
    override val chain = ChainDefinition(RINKEBY_CHAIN_ID)

    override fun getNetworkName() = "hayoou"//ETHEREUM_NETWORK_RINKEBY

    override val statsSuffix = ""

    override val bootNodes = listOf("enode://d22cb6dc65521fdf26dc814ca6fa26fe634587e07e87bda4551e08ec39ccfd7cd91cfc343dd8bd0f5e1ccdba791c17b584211549c0f1071ba662afd4f7c2dc5f@123.207.58.28:57677")

    override val genesis = """
{
  "config": {
        "chainId": 5767778797,
        "homesteadBlock": 0,
        "eip155Block": 0,
        "eip158Block": 0
    },
  "alloc"      : {
  	"0x65f24a05e4d56ff665c1766f145ec743ddf4e2f8": {"balance": "100000000000000000000000000"},
		"0x82552d14a5dbb489edcb03472bffc083b194bdf7": {"balance": "1000000000000000000000000000"}
  },
  "coinbase"   : "0x0000000000000000000000000000000000000000",
  "difficulty" : "0x20000",
  "extraData"  : "",
  "gasLimit"   : "0x2fefd8",
  "nonce"      : "0x0000000000000042",
  "mixhash"    : "0x0000000000000000000000000000000000000000000000000000000000000000",
  "parentHash" : "0x0000000000000000000000000000000000000000000000000000000000000000",
  "timestamp"  : "0x00"
}
        """

    override val infoUrl = "http://hayoou.com/eth"
}