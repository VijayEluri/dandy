package org.workhabit.drupal.api.site.v2.site.local;

import org.junit.Before;
import org.junit.Test;
import org.workhabit.drupal.api.CommonsHttpClientDrupalServicesRequestManager;
import org.workhabit.drupal.api.entity.DrupalComment;
import org.workhabit.drupal.api.entity.DrupalNode;
import org.workhabit.drupal.api.site.exceptions.DrupalFetchException;
import org.workhabit.drupal.api.site.impl.v2.DrupalSiteContextV2Impl;
import org.workhabit.drupal.api.site.impl.v2.KeyRequestSigningInterceptorImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 11/12/10, 10:56 AM
 */
public class LocalDrupalSiteContextV2ImplTest {
    private DrupalSiteContextV2Impl drupalSiteContext;

    @Before
    public void setUp() {
        CommonsHttpClientDrupalServicesRequestManager manager = new CommonsHttpClientDrupalServicesRequestManager();
        KeyRequestSigningInterceptorImpl requestSigningInterceptor = new KeyRequestSigningInterceptorImpl();
        requestSigningInterceptor.setDrupalDomain("workhabit.com");
        requestSigningInterceptor.setPrivateKey("9e47c52fae3c36baff404f7072e46547");
        manager.setRequestSigningInterceptor(requestSigningInterceptor);

        drupalSiteContext = new DrupalSiteContextV2Impl("http://ad.hourglassone.com");
        drupalSiteContext.setDrupalServicesRequestManager(manager);
    }

    @Test
    public void testSaveComment() throws DrupalFetchException {
        DrupalComment comment = new DrupalComment();
        comment.setNid(1);
        comment.setComment("test body 1");
        comment.setSubject("Test title");
        comment.setUid(0);
        //comment.setUid(1);
        drupalSiteContext.saveComment(comment);
    }

    @Test
    public void testGetNode() throws DrupalFetchException {
        DrupalNode node = drupalSiteContext.getNode(4);
    }

    @Test
    public void testGetFileDirectory() throws DrupalFetchException {
        String fileDirectoryPath = drupalSiteContext.getFileDirectoryPath();
        assertNotNull(fileDirectoryPath);
        assertFalse("{\"#message\":\"Access denied\",\"#error\":true}".equals(fileDirectoryPath));
    }
}