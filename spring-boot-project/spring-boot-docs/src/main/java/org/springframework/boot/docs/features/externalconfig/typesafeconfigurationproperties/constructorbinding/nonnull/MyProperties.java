/*
 * Copyright 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.docs.features.externalconfig.typesafeconfigurationproperties.constructorbinding.nonnull;

import java.net.InetAddress;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("my.service")
public class MyProperties {

	private final boolean enabled;

	private final InetAddress remoteAddress;

	private final Security security;

	// tag::code[]
	public MyProperties(boolean enabled, InetAddress remoteAddress, @DefaultValue Security security) {
		this.enabled = enabled;
		this.remoteAddress = remoteAddress;
		this.security = security;
	}
	// end::code[]

	public boolean isEnabled() {
		return this.enabled;
	}

	public InetAddress getRemoteAddress() {
		return this.remoteAddress;
	}

	public Security getSecurity() {
		return this.security;
	}

	public static class Security {

		private final String username;

		private final String password;

		private final List<String> roles;

		public Security(String username, String password, @DefaultValue("USER") List<String> roles) {
			this.username = username;
			this.password = password;
			this.roles = roles;
		}

		public String getUsername() {
			return this.username;
		}

		public String getPassword() {
			return this.password;
		}

		public List<String> getRoles() {
			return this.roles;
		}

	}

}
