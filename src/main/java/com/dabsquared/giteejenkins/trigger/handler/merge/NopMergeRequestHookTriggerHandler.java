package com.dabsquared.giteejenkins.trigger.handler.merge;

import com.dabsquared.giteejenkins.gitee.hook.model.MergeRequestHook;
import com.dabsquared.giteejenkins.trigger.filter.BranchFilter;
import com.dabsquared.giteejenkins.trigger.filter.MergeRequestLabelFilter;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
class NopMergeRequestHookTriggerHandler implements MergeRequestHookTriggerHandler {
    @Override
    public void handle(Job<?, ?> job, MergeRequestHook hook, boolean ciSkip, BranchFilter branchFilter, MergeRequestLabelFilter mergeRequestLabelFilter) {
        // nothing to do
    }
}
