package io.deep27soft.wildos;

import org.loadtest4j.LoadTester;
import org.loadtest4j.Request;
import org.loadtest4j.Result;
import org.loadtest4j.drivers.gatling.GatlingBuilder;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class MainLT {

    private final LoadTester loadTester = GatlingBuilder.withUrl("https://www.wildberries.ru")
            .withDuration(Duration.ofSeconds(60))
            .withUsersPerSecond(256 + 64 + 16)
            .build();

    @Test
    public void test() {
        Request request = Request.get("/homesidebar")
                .withHeader("cookie", "route=747af9f657950bff1c38771fb22b3d471b3cbe5d; _gcl_au=1.1.1987378272.1573577230; _ga=GA1.2.753932966.1573577231; BasketUID=f804627e-cdf9-4114-b3b4-bbc0c5fb52c0; ___wbu=24a55cac-8682-419c-ab69-3c1779de111a.1573577230; .AspNetCore.Antiforgery.stpccMUKFUM=CfDJ8DC3tZ9IPNVCoaQu8ZNITuFq_HUR3nmXJt_60kWAQ0x31QBG9w764wrikSqE1BQNPak3I85_IsklMTBBnGbfT7G9JmZgITmxre8Cr7gtJgQ8HzQLXIRhYHvjkKX8dRV1zW2yAFkMrX6EmS-PBmyM77M; _wbSes=CfDJ8DC3tZ9IPNVCoaQu8ZNITuGp72tbQilR%2FMGKOmmVF9HgjEHVG0K%2BzHE81%2Bewc%2B%2BE0XaA1zsYNMUW5DQOXpOgroOeTAg2HfVpOEvcrOlC6vLbryNj2XG0HCzAt7M3whnb6iaxPy9Thrl0VeVSZyXQDXXJpG%2FCjFAjSehf%2FxbVXBNv; mobile_client=0; __wbl=cityId%3D77%26regionId%3D77%26city%3D%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%26phone%3D84957755505%26latitude%3D55%2C7247%26longitude%3D37%2C7882%26ipCountry%3D%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F; __store=507_3158_2737_1699_1733_686; __region=63_22_30_48_66_33_31_1_38_40_65_4; __pricemargin=1.0--; ncache=0%3B507_3158_2737_1699_1733_686%3B63_22_30_48_66_33_31_1_38_40_65_4%3B1.0--; ___wbs=d383543d-52e4-4c28-ad37-7b05b03183af.1580153457; _gid=GA1.2.1731707408.1580153458; _pk_ref.1.034e=%5B%22%22%2C%22%22%2C1580153459%2C%22https%3A%2F%2Fwww.google.com%2F%22%5D; _pk_ses.1.034e=*; criteo_uid=OznzOvi0d3kZ5CvZNKLopTDWQuRg1sOH; _pk_id.1.034e=d5e5290a97dbbbdd.1573577232.2.1580153473.1580153459.")
                .withHeader("Accept", "*/*");
        Result result = loadTester.run(Arrays.asList(request));

        assertThat(result.getResponseTime().getPercentile(90), lessThanOrEqualTo(Duration.ofMillis(500)));
    }
}
