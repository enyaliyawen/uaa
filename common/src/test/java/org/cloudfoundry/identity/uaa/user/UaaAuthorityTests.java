/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cloudfoundry.identity.uaa.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Dave Syer
 * 
 */
public class UaaAuthorityTests {

	@Test
	public void testGetAuthority() {
		assertEquals("uaa.user", UaaAuthority.UAA_USER.getAuthority());
	}

	@Test
	public void testValueOf() {
		assertEquals(0, UaaAuthority.UAA_USER.value());
		assertEquals(1, UaaAuthority.UAA_ADMIN.value());
	}

	@Test
	public void testAdminFromAuthorities() {
		assertEquals(UaaAuthority.UAA_ADMIN, UaaAuthority.fromAuthorities("uaa.user,uaa.admin"));
	}
	
	@Test
	public void testAuthority() {
		assertEquals(UaaAuthority.UAA_ADMIN, UaaAuthority.authority("uaa.admin"));
		assertEquals(UaaAuthority.UAA_USER, UaaAuthority.authority("uaa.user"));
		assertEquals(new SimpleGrantedAuthority("tacos"), UaaAuthority.authority("tacos"));
	}
	
	@Test
	@Ignore("Is this a worth while test")
	public void testSubstringAuthority() {
		assertFalse(UaaAuthority.UAA_ADMIN.equals(UaaAuthority.authority("some.scope.with.subscope.uaa.admin")));

	}

}
