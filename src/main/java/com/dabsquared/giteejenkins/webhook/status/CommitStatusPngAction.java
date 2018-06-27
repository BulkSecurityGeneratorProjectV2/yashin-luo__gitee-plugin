package com.dabsquared.giteejenkins.webhook.status;

import com.dabsquared.giteejenkins.util.BuildUtil;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
public class CommitStatusPngAction extends StatusPngAction {
    public CommitStatusPngAction(Job<?, ?> project, String sha1) {
        super(project, BuildUtil.getBuildBySHA1WithoutMergeBuilds(project, sha1));
    }
}
