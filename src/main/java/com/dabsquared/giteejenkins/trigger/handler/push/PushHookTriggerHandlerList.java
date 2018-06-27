package com.dabsquared.giteejenkins.trigger.handler.push;

import com.dabsquared.giteejenkins.gitee.hook.model.PushHook;
import com.dabsquared.giteejenkins.trigger.filter.BranchFilter;
import com.dabsquared.giteejenkins.trigger.filter.MergeRequestLabelFilter;
import hudson.model.Job;

import java.util.List;

/**
 * @author Robin Müller
 */
class PushHookTriggerHandlerList implements PushHookTriggerHandler {

    private final List<PushHookTriggerHandler> handlers;

    PushHookTriggerHandlerList(List<PushHookTriggerHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void handle(Job<?, ?> job, PushHook hook, boolean ciSkip, BranchFilter branchFilter, MergeRequestLabelFilter mergeRequestLabelFilter) {
        for (PushHookTriggerHandler handler : handlers) {
            handler.handle(job, hook, ciSkip, branchFilter, mergeRequestLabelFilter);
        }
    }
}
