package com.dabsquared.giteejenkins.trigger.handler.pipeline;

import com.dabsquared.giteejenkins.gitee.hook.model.PipelineHook;
import com.dabsquared.giteejenkins.trigger.filter.BranchFilter;
import com.dabsquared.giteejenkins.trigger.filter.MergeRequestLabelFilter;
import hudson.model.Job;

/**
 * @author Milena Zachow
 */
class NopPipelineHookTriggerHandler implements PipelineHookTriggerHandler {

    @Override
    public void handle(Job<?, ?> job, PipelineHook hook, boolean ciSkip, BranchFilter branchFilter, MergeRequestLabelFilter mergeRequestLabelFilter) {

    }
}
