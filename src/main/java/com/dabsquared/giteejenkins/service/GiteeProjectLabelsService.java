package com.dabsquared.giteejenkins.service;


import com.dabsquared.giteejenkins.gitee.api.GiteeClient;
import com.dabsquared.giteejenkins.gitee.api.model.Label;
import com.dabsquared.giteejenkins.util.LoggerUtil;
import com.dabsquared.giteejenkins.util.ProjectIdUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GiteeProjectLabelsService {

    private static final Logger LOGGER = Logger.getLogger(GiteeProjectLabelsService.class.getName());

    private static transient GiteeProjectLabelsService instance;
    private final Cache<String, List<String>> projectLabelsCache;

    GiteeProjectLabelsService() {
        this.projectLabelsCache = CacheBuilder.<String, String>newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build();
    }

    public static GiteeProjectLabelsService instance() {
        if (instance == null) {
            instance = new GiteeProjectLabelsService();
        }
        return instance;
    }

    public List<String> getLabels(GiteeClient client, String sourceRepositoryString) {
        synchronized (projectLabelsCache) {
            try {
                return projectLabelsCache.get(sourceRepositoryString, new LabelNamesLoader(client, sourceRepositoryString));
            } catch (ExecutionException e) {
                throw new LabelLoadingException(e);
            }
        }
    }

    public static class LabelLoadingException extends RuntimeException {
        LabelLoadingException(Throwable cause) {
            super(cause);
        }
    }

    private static class LabelNamesLoader implements Callable<List<String>> {
        private final GiteeClient client;
        private final String sourceRepository;

        private LabelNamesLoader(GiteeClient client, String sourceRepository) {
            this.client = client;
            this.sourceRepository = sourceRepository;
        }

        @Override
        public List<String> call() throws Exception {
            List<String> result = new ArrayList<>();
            String projectId = ProjectIdUtil.retrieveProjectId(client, sourceRepository);
            for (Label label : client.getLabels(projectId)) {
                result.add(label.getName());
            }
            LOGGER.log(Level.FINEST, "found these labels for repo {0} : {1}", LoggerUtil.toArray(sourceRepository, result));
            return result;
        }
    }
}
