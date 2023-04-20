package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.user.UICurrency
import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import com.yama.cryptowalletservice.model.wallet.Wallet
import org.springframework.stereotype.Service

@Service
class PricesConversionService {

    val cryptoPricesInUSD = mapOf<CryptoCurrency, Double>(
        Pair(CryptoCurrency.BITCOIN, 100.0),
        Pair(CryptoCurrency.LITECOIN, 100.0),
        Pair(CryptoCurrency.DASH, 100.0),
        Pair(CryptoCurrency.ETHEREUM, 50.0)
    )

    val fiatPricesToUSD = mapOf<UICurrency, Double>(
        Pair(UICurrency.USD, 1.0),
        Pair(UICurrency.EUR, 2.0),
        Pair(UICurrency.KZT, 30.0),
        Pair(UICurrency.RUB, 50.0)
    )

    fun getTotalBalance(wallets: List<Wallet>, currency: UICurrency): Double {
        return wallets.map { wallet ->
            wallet.balance * cryptoPricesInUSD[wallet.currency]!! * fiatPricesToUSD[currency]!!
        }.sum()
    }
}
