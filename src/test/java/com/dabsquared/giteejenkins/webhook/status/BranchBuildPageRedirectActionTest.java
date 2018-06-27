package com.dabsquared.giteejenkins.webhook.status;

import hudson.model.FreeStyleProject;

/**
 * @author Robin Müller
 */
public class BranchBuildPageRedirectActionTest extends BuildPageRedirectActionTest {
    @Override
    protected BuildPageRedirectAction getBuildPageRedirectAction(FreeStyleProject project) {
        return new BranchBuildPageRedirectAction(project, branch);
    }
}
