package com.cinexpress.videofriend.services;


import com.cinexpress.videofriend.models.PremiumSubscription;

public interface PremiumSubscriptionService {
    PremiumSubscription activatePremiumSubscription(Long id, PremiumSubscription ps);
    Boolean hasDiscount(Long id);
    Boolean hasExcusiveCatalog(Long id);
}
