package com.dabsquared.giteejenkins.gitee.api.impl;


import com.dabsquared.giteejenkins.gitee.api.GiteeClient;
import com.dabsquared.giteejenkins.gitee.api.GiteeClientBuilder;
import hudson.Extension;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;


@Extension
@Restricted(NoExternalUse.class)
public final class AutodetectGiteeClientBuilder extends GiteeClientBuilder {
    public AutodetectGiteeClientBuilder() {
        super("autodetect", 0);
    }

    @Override
    @Nonnull
    public GiteeClient buildClient(String url, String token, boolean ignoreCertificateErrors, int connectionTimeout, int readTimeout) {
        Collection<GiteeClientBuilder> candidates = new ArrayList<>(getAllGitLabClientBuilders());
        candidates.remove(this);
        return new AutodetectingGiteeClient(candidates, url, token, ignoreCertificateErrors, connectionTimeout, readTimeout);
    }
}
