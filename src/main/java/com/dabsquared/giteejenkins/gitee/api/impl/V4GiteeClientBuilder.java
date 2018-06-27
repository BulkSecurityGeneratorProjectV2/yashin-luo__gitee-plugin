package com.dabsquared.giteejenkins.gitee.api.impl;


import com.dabsquared.giteejenkins.gitee.api.model.MergeRequest;
import com.google.common.base.Function;
import hudson.Extension;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;


@Extension
@Restricted(NoExternalUse.class)
public final class V4GiteeClientBuilder extends ResteasyGiteeClientBuilder {
    private static final int ORDINAL = 1;
    private static final Function<MergeRequest, Integer> MERGE_REQUEST_ID_PROVIDER = new Function<MergeRequest, Integer>() {
        @Override
        public Integer apply(MergeRequest mergeRequest) {
            return mergeRequest.getIid();
        }
    };

    public V4GiteeClientBuilder() {
        super(V4GiteeApiProxy.ID, ORDINAL, V4GiteeApiProxy.class, MERGE_REQUEST_ID_PROVIDER);
    }
}
