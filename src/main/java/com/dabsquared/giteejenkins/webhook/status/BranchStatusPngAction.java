package com.dabsquared.giteejenkins.webhook.status;

import com.dabsquared.giteejenkins.util.BuildUtil;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
public class BranchStatusPngAction extends StatusPngAction {
    public BranchStatusPngAction(Job<?, ?> project, String branchName) {
        super(project, BuildUtil.getBuildByBranch(project, branchName));
    }
}
