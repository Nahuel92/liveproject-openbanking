package org.nahuelrodriguez.openbankingapp.repositories;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MerchantDetailsRepositoryImpl implements MerchantDetailsRepository {
    private static final Map<String, String> merchantsLogos = Map.ofEntries(
            Map.entry("Acme", "acme-logo.png"),
            Map.entry("Globex", "globex-logo.png"),
            Map.entry("Morley", "morley-logo.png"),
            Map.entry("Contoso", "contoso-logo.png")
    );

    public String getMerchantLogo(final String merchantKey) {
        return merchantsLogos.get(merchantKey.toLowerCase());
    }
}
