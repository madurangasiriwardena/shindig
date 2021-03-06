/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shindig.gadgets.oauth;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.uri.Uri;
import org.apache.shindig.gadgets.GadgetContext;

/**
 * GadgetContext for use when handling an OAuth request.
 */
public class OAuthGadgetContext extends GadgetContext {

  private final SecurityToken securityToken;
  private final String container;
  private final Uri appUrl;
  private final boolean bypassSpecCache;

  public OAuthGadgetContext(SecurityToken securityToken, OAuthArguments arguments) {
    this.securityToken = securityToken;
    this.container = securityToken.getContainer();
    this.appUrl = Uri.parse(securityToken.getAppUrl());
    this.bypassSpecCache = arguments.getBypassSpecCache();
  }

  @Override
  public String getContainer() {
    return container;
  }

  @Override
  public SecurityToken getToken() {
    return securityToken;
  }

  @Override
  public Uri getUrl() {
    return appUrl;
  }

  @Override
  public boolean getIgnoreCache() {
    return bypassSpecCache;
  }
}
