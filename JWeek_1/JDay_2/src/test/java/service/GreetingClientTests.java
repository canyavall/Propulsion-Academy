/*
 * Copyright 2016-2017 the original author or authors.
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

package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class GreetingClientTests {

	@Test
	public void englishIntegrationTest() {
		MessageService messageService = new EnglishMessageService();
		GreetingClient client = new GreetingClient(messageService);

		assertEquals("HELLO, YODA", client.greetUser("Yoda"));
	}

	@Test
	public void stubUnitTest() {
		MessageService messageService = new StubMessageService();
		GreetingClient client = new GreetingClient(messageService);

		assertEquals("HEY!", client.greetUser("Yoda"));
	}

	@Test
	public void mockUnitTest() {
		MessageService messageService = mock(MessageService.class);
		// when(messageService.generateMessage("Luke")).thenReturn("Foo!");
		when(messageService.generateMessage(anyString())).thenReturn("Foo!");

		GreetingClient client = new GreetingClient(messageService);

		assertEquals("FOO!", client.greetUser("doesn't matter"));

		// Optionally verify how mock was used.
		// verify(messageService).generateMessage("doesn't matter");
	}

}	