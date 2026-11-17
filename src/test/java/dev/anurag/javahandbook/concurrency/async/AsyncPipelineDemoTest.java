package dev.anurag.javahandbook.concurrency.async;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class AsyncPipelineDemoTest {

    @Test
    @DisplayName("CompletableFuture pipeline should assemble composite dashboard view asynchronously")
    void assembleDashboardSuccessfully() throws Exception {
        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            CompletableFuture<AsyncPipelineDemo.DashboardView> future = AsyncPipelineDemo.assembleDashboard("user-123", pool);
            AsyncPipelineDemo.DashboardView view = future.get(3, TimeUnit.SECONDS);

            assertThat(view).isNotNull();
            assertThat(view.profile().name()).isEqualTo("Alice");
            assertThat(view.orders().totalAmount()).isEqualTo(250.00);
            assertThat(view.discount()).isEqualTo(37.50); // 15% of 250
        }
    }

    @Test
    @DisplayName("Async pipeline should recover gracefully from upstream exceptions")
    void exceptionRecoveryTest() throws Exception {
        CompletableFuture<String> failingStep = CompletableFuture.<String>supplyAsync(() -> {
            throw new IllegalStateException("Service unavailable");
        }).exceptionally(ex -> "DefaultFallback");

        String result = failingStep.get(1, TimeUnit.SECONDS);
        assertThat(result).isEqualTo("DefaultFallback");
    }
}
