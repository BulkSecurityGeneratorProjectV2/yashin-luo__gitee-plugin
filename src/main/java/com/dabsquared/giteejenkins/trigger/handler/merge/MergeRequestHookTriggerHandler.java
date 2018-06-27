package com.dabsquared.giteejenkins.trigger.handler.merge;

import com.dabsquared.giteejenkins.gitee.hook.model.MergeRequestHook;
import com.dabsquared.giteejenkins.trigger.handler.WebHookTriggerHandler;

/**
 * @author Robin Müller
 */
public interface MergeRequestHookTriggerHandler extends WebHookTriggerHandler<MergeRequestHook> { }
