package com.mparticle.kits

import android.app.Application
import android.content.Context
import com.mparticle.MParticle
import com.stepleaderdigital.reveal.Reveal

class RevealMobileKit : KitIntegration() {
    override fun onKitCreate(
        settings: Map<String, String>,
        context: Context
    ): List<ReportingMessage> {
        val revealSDK = Reveal.getInstance()
        val apiKey = settings[API_KEY]
        val endpointBase = settings[SDK_ENDPOINT]
        if (MParticle.getInstance()?.environment == MParticle.Environment.Development) {
            revealSDK.setDebug(true)
        }
        if (apiKey != null) {
            revealSDK.apiKey = apiKey
            revealSDK.setServiceType(Reveal.ServiceType.PRODUCTION)
            if (endpointBase != null) revealSDK.setAPIEndpointBase(endpointBase)
        } else {
            throw IllegalArgumentException(NO_API_KEY_REQUIRED)
        }
        revealSDK.start(context.applicationContext as Application)
        return emptyList()
    }

    override fun getName(): String = KIT_NAME

    override fun setOptOut(optedOut: Boolean): List<ReportingMessage> = emptyList()


    companion object{
        private const val KIT_NAME = "Reveal Mobile"
        private const val NO_API_KEY_REQUIRED = "No API Key provided"
        private const val SDK_ENDPOINT = "sdk_endpoint"
        private const val API_KEY = "apiKey"
    }
}
