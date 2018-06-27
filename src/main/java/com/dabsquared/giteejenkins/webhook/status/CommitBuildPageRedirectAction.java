package com.dabsquared.giteejenkins.webhook.status;

import com.dabsquared.giteejenkins.util.BuildUtil;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
public class CommitBuildPageRedirectAction extends BuildPageRedirectAction {
    public CommitBuildPageRedirectAction(Job<?, ?> project, String sha1) {
        super(BuildUtil.getBuildBySHA1IncludingMergeBuilds(project, sha1));
    }
}
