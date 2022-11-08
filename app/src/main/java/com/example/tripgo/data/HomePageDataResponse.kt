package com.example.tripgo.data

import androidx.annotation.Keep


@Keep
data class Title(val title: String? = null, val action: String? = null)

@Keep
data class OffersResponse(var imageUrl: String? = null,
                          var offerDeepLink: String? = null)

@Keep
data class Trending(var imageUrl: String? = null,
                    var offerDeepLink: String? = null)

@Keep
data class Recommended(val imageUrl: String? = null,
                       val offerDeepLink: String? = null,
                       val title: String? = null,
                       val price: String? = null,
                       val amountInGram: String? = null,
                       val id: String? = null)