package com.dabsquared.giteejenkins.gitee.api;


import com.dabsquared.giteejenkins.gitee.api.impl.AutodetectGiteeClientBuilder;
import com.dabsquared.giteejenkins.gitee.api.impl.V3GiteeClientBuilder;
import com.dabsquared.giteejenkins.gitee.api.impl.V4GiteeClientBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import java.util.List;
import java.util.NoSuchElementException;

import static com.dabsquared.giteejenkins.gitee.api.GiteeClientBuilder.getAllGitLabClientBuilders;
import static com.dabsquared.giteejenkins.gitee.api.GiteeClientBuilder.getGitLabClientBuilderById;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;


public class GiteeClientBuilderTest {
    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    @Test
    public void getAllGitLabClientBuilders_list_is_sorted_by_ordinal() {
        List<GiteeClientBuilder> builders = getAllGitLabClientBuilders();
        assertThat(builders.get(0), instanceOf(AutodetectGiteeClientBuilder.class));
        assertThat(builders.get(1), instanceOf(V4GiteeClientBuilder.class));
        assertThat(builders.get(2), instanceOf(V3GiteeClientBuilder.class));
    }

    @Test
    public void getGitLabClientBuilderById_success() {
        assertThat(getGitLabClientBuilderById(new V3GiteeClientBuilder().id()), instanceOf(V3GiteeClientBuilder.class));
    }

    @Test(expected = NoSuchElementException.class)
    public void getGitLabClientBuilderById_no_match() {
        getGitLabClientBuilderById("unknown");
    }
}
