package com.dabsquared.giteejenkins.trigger.handler.push;

import com.dabsquared.giteejenkins.gitee.hook.model.PushHook;
import com.dabsquared.giteejenkins.trigger.filter.BranchFilter;
import com.dabsquared.giteejenkins.trigger.filter.MergeRequestLabelFilter;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
class NopPushHookTriggerHandler implements PushHookTriggerHandler {
    @Override
    public void handle(Job<?, ?> job, PushHook hook, boolean ciSkip, BranchFilter branchFilter, MergeRequestLabelFilter mergeRequestLabelFilter) {
        // nothing to do
    }
}
