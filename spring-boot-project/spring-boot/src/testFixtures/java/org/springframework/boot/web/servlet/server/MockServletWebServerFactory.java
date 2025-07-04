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

package org.springframework.boot.web.servlet.server;

import jakarta.servlet.ServletContext;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.MockServletWebServer.RegisteredFilter;
import org.springframework.boot.web.servlet.server.MockServletWebServer.RegisteredServlet;

import static org.mockito.Mockito.spy;

/**
 * Mock {@link ServletWebServerFactory}.
 *
 * @author Phillip Webb
 * @author Andy Wilkinson
 */
public class MockServletWebServerFactory extends AbstractServletWebServerFactory {

	private MockServletWebServer webServer;

	@Override
	public WebServer getWebServer(ServletContextInitializer... initializers) {
		this.webServer = spy(new MockServletWebServer(mergeInitializers(initializers), getPort()));
		return this.webServer;
	}

	public MockServletWebServer getWebServer() {
		return this.webServer;
	}

	public ServletContext getServletContext() {
		return (getWebServer() != null) ? getWebServer().getServletContext() : null;
	}

	public RegisteredServlet getRegisteredServlet(int index) {
		return (getWebServer() != null) ? getWebServer().getRegisteredServlet(index) : null;
	}

	public RegisteredFilter getRegisteredFilter(int index) {
		return (getWebServer() != null) ? getWebServer().getRegisteredFilters(index) : null;
	}

}
