/*
 * Copyright (c) 2011-2013 GoPivotal, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package reactor.groovy.ext

import groovy.transform.CompileStatic
import reactor.event.EventBus
import reactor.function.Functions
import reactor.groovy.support.ClosureConsumer
import reactor.groovy.support.ClosureSupplier
import reactor.rx.Promise
import reactor.rx.Promises

/**
 * Static extensions for reactor-core classes, main purpose is to bind closure when required
 *
 * @author Stephane Maldini
 */
@CompileStatic
class ReactorStaticExtensions {

	/**
	 * Closure converters
	 */
	static <T> void schedule(final Functions selfType, final T value, final EventBus reactor, final Closure closure) {
		reactor.schedule new ClosureConsumer(closure), value
	}

	static <T> Promise<T> from(final Promise<T> selfType, Closure<T> callback) {
		Promises.syncTask(new ClosureSupplier<T>(callback))
	}

}
