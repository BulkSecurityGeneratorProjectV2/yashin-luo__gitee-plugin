package com.dabsquared.giteejenkins.webhook.status;

import hudson.model.FreeStyleProject;

/**
 * @author Robin Müller
 */
public class CommitBuildPageRedirectActionTest extends BuildPageRedirectActionTest {
    @Override
    protected BuildPageRedirectAction getBuildPageRedirectAction(FreeStyleProject project) {
        return new CommitBuildPageRedirectAction(project, commitSha1);
    }
}
