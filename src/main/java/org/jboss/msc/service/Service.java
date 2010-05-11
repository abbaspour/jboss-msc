/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.msc.service;

import org.jboss.msc.value.ImmediateValue;
import org.jboss.msc.value.Value;

/**
 * A service is a thing which can be started and stopped.
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public interface Service {

    /**
     * Start the service.  Do not return until the service has been fully started, unless an asynchronous service
     * start is performed.
     *
     * @param context the context which can be used to trigger an asynchronous service start
     * @throws StartException if the service could not be started for some reason
     */
    void start(StartContext context) throws StartException;

    /**
     * Stop the service.  Do not return until the service has been fully stopped, unless an asynchronous service
     * stop is performed.
     *
     * @param context the context which can be used to trigger an asynchronous service stop
     */
    void stop(StopContext context);

    /**
     * A simple null service which performs no start or stop action.
     */
    Service NULL = new Service() {
        public void start(final StartContext context) {
        }

        public void stop(final StopContext context) {
        }
    };

    /**
     * A value which resolves to the {@link #NULL null service}.
     */
    Value<Service> NULL_VALUE = new ImmediateValue<Service>(NULL);
}