package com.dabsquared.giteejenkins.testhelpers;

import com.dabsquared.giteejenkins.gitee.hook.model.PushHook;

public interface GiteePushRequestSamples {
    PushHook pushBrandNewMasterBranchRequest();

    PushHook pushNewBranchRequest();

    PushHook pushCommitRequest();

    PushHook mergePushRequest();

    PushHook pushNewTagRequest();

    PushHook deleteBranchRequest();
}
