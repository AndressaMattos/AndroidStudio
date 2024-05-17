interface Endpoint {
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getCurrencies() : Call<JsonObject>

    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies/{from}/{to}.json")
    fun getCurrencyRate(@Path(value = "from", encoded = true) from : String,
                        @Path(value = "to", encoded = true) to : String)
                        : Call<JsonObject>
}