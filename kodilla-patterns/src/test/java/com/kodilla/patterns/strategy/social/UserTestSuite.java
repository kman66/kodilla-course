package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User darrenJohnson = new YGeneration("Darren Johnson");
        User johnSmith = new ZGeneration("John Smith");
        User sussieNaylor = new Millenials("Sussie Naylor");

        //When
        String darrenSharesOn = darrenJohnson.sharePost();
        String johnSharesOn = johnSmith.sharePost();
        String sussieSharesOn = sussieNaylor.sharePost();

        //Then
        Assert.assertEquals("[Twitter publisher] Sharing one post", darrenSharesOn);
        Assert.assertEquals("[Facebook publisher] Sharing one post", johnSharesOn);
        Assert.assertEquals("[Snapchat publisher] Sharing one post", sussieSharesOn);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User johnBean = new YGeneration("John Bean");

        //When
        String johnsDefaultPublisher = johnBean.sharePost();
        johnBean.setSocialPublisher(new SnapchatPublisher());
        String johnsNewPublisher = johnBean.sharePost();

        //Then
        Assert.assertEquals("[Twitter publisher] Sharing one post", johnsDefaultPublisher);
        Assert.assertEquals("[Snapchat publisher] Sharing one post", johnsNewPublisher);
    }
}
