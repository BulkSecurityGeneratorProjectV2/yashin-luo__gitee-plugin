package com.dabsquared.giteejenkins.gitee.api.impl;


import com.dabsquared.giteejenkins.gitee.api.model.MergeRequest;
import com.google.common.base.Function;
import hudson.Extension;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;


@Extension
@Restricted(NoExternalUse.class)
public final class V3GiteeClientBuilder extends ResteasyGiteeClientBuilder {
    private static final int ORDINAL = 2;
    private static final Function<MergeRequest, Integer> MERGE_REQUEST_ID_PROVIDER = new Function<MergeRequest, Integer>() {
        @Override
        public Integer apply(MergeRequest mergeRequest) {
            return mergeRequest.getId();
        }
    };

    public V3GiteeClientBuilder() {
        super(V3GiteeApiProxy.ID, ORDINAL, V3GiteeApiProxy.class, MERGE_REQUEST_ID_PROVIDER);
    }
}
