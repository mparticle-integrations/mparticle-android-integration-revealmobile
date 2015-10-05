package com.mparticle.kits;

import android.content.Context;

import com.mparticle.MParticle;
import com.stepleaderdigital.reveal.Reveal;

import java.util.List;
import java.util.Map;

public class RevealMobileKit extends KitIntegration {

    @Override
    protected List<ReportingMessage> onKitCreate(Map<String, String> settings, Context context) {
        Reveal revealSDK = Reveal.getInstance();
        String apiKey = settings.get("apiKey");

        if (MParticle.getInstance().getEnvironment().equals(MParticle.Environment.Development)) {
            revealSDK.setDebug(true);
        }

        if (apiKey != null) {
            revealSDK.setAPIKey(apiKey);
            revealSDK.setServiceType(Reveal.ServiceType.PRODUCTION);
        } else {
            throw new IllegalArgumentException("No API Key provided");
        }
        revealSDK.start(context);
        return null;
    }

    @Override
    public String getName() {
        return "Reveal Mobile";
    }

    @Override
    public List<ReportingMessage> setOptOut(boolean optedOut) {
        return null;
    }
}