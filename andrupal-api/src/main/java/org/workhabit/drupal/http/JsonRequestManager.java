package org.workhabit.drupal.http;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: Oct 22, 2010, 10:12:37 PM
 */
public interface JsonRequestManager {
    public String post(String path, String method, Map<String, Object> data) throws IOException;

    public String postSigned(String path, String method, Map<String, Object> data) throws IOException, NoSuchAlgorithmException;
}
