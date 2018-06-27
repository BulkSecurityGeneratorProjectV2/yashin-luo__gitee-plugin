package com.dabsquared.giteejenkins.trigger.handler;

import com.dabsquared.giteejenkins.gitee.hook.model.WebHook;
import com.dabsquared.giteejenkins.trigger.filter.BranchFilter;
import com.dabsquared.giteejenkins.trigger.filter.MergeRequestLabelFilter;
import hudson.model.Job;

/**
 * @author Robin Müller
 */
public interface WebHookTriggerHandler<H extends WebHook> {

    void handle(Job<?, ?> job, H hook, boolean ciSkip, BranchFilter branchFilter, MergeRequestLabelFilter mergeRequestLabelFilter);
}
