/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package jakarta.mail.search;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;

/**
 * @version $Rev$ $Date$
 */
public final class SubjectTerm extends StringTerm {
	
	private static final long serialVersionUID = 7481568618055573432L;
	
    public SubjectTerm(final String subject) {
        super(subject);
    }

    @Override
    public boolean match(final Message message) {
        try {
            final String subject = message.getSubject(); 
            if (subject == null) {
                return false; 
            }
            return match(subject);
        } catch (final MessagingException e) {
            return false;
        }
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
			return true;
		}
        if (other instanceof SubjectTerm == false) {
			return false;
		}
        return super.equals(other); 
    }
}
