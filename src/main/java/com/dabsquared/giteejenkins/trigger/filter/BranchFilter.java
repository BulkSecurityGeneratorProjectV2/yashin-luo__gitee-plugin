package com.dabsquared.giteejenkins.trigger.filter;

/**
 * @author Robin Müller
 */
public interface BranchFilter {

    boolean isBranchAllowed(String branchName);
}
