package dev.anurag.javahandbook.concurrency.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates modern asynchronous programming with {@link CompletableFuture}:
 * <ul>
 *   <li>Non-blocking composition with {@code thenApplyAsync} and {@code thenCompose}</li>
 *   <li>Combining independent futures using {@code thenCombine}</li>
 *   <li>Resilient error recovery via {@code exceptionally} and {@code handle}</li>
 * </ul>
 */
public class AsyncPipelineDemo {

    public record UserProfile(String id, String name, String tier) {}
    public record OrderSummary(String userId, double totalAmount, int itemCount) {}
    public record DashboardView(UserProfile profile, OrderSummary orders, double discount) {}

    public static CompletableFuture<UserProfile> fetchUserProfile(String userId, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate network latency
            return new UserProfile(userId, "Alice", "PREMIUM");
        }, executor);
    }

    public static CompletableFuture<OrderSummary> fetchOrderSummary(String userId, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            return new OrderSummary(userId, 250.00, 3);
        }, executor);
    }

    public static CompletableFuture<Double> calculateDiscount(UserProfile profile, OrderSummary orders) {
        return CompletableFuture.supplyAsync(() -> {
            if ("PREMIUM".equals(profile.tier()) && orders.totalAmount() > 100.0) {
                return orders.totalAmount() * 0.15; // 15% discount
            }
            return 0.0;
        });
    }

    public static CompletableFuture<DashboardView> assembleDashboard(String userId, ExecutorService executor) {
        CompletableFuture<UserProfile> profileFuture = fetchUserProfile(userId, executor);
        CompletableFuture<OrderSummary> ordersFuture = fetchOrderSummary(userId, executor);

        return profileFuture.thenCombine(ordersFuture, (profile, orders) -> {
            double discount = "PREMIUM".equals(profile.tier()) && orders.totalAmount() > 100.0 ? orders.totalAmount() * 0.15 : 0.0;
            return new DashboardView(profile, orders, discount);
        }).exceptionally(ex -> {
            return new DashboardView(new UserProfile(userId, "Fallback", "STANDARD"), new OrderSummary(userId, 0.0, 0), 0.0);
        });
    }
}

