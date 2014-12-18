/* ========================================================================== *
 *         Copyright (C) 2004-2006, Pier Fumagalli <http://could.it/>         *
 *                            All rights reserved.                            *
 * ========================================================================== *
 *                                                                            *
 * Licensed under the  Apache License, Version 2.0  (the "License").  You may *
 * not use this file except in compliance with the License.  You may obtain a *
 * copy of the License at <http://www.apache.org/licenses/LICENSE-2.0>.       *
 *                                                                            *
 * Unless  required  by applicable  law or  agreed  to  in writing,  software *
 * distributed under the License is distributed on an  "AS IS" BASIS, WITHOUT *
 * WARRANTIES OR  CONDITIONS OF ANY KIND, either express or implied.  See the *
 * License for the  specific language  governing permissions  and limitations *
 * under the License.                                                         *
 *                                                                            *
 * ========================================================================== */
package it.could.webdav;

import java.io.File;
import java.net.URI;

/**
 * Strategy for creating DAVResource implementations
 */
public interface DAVResourceFactory {

    /**
     * <p>Return the {@link DAVResource} associated with a {@link URI}.</p>
     *
     * <p>If the specified {@link URI} is relative it will be resolved against
     * the root of this {@link DAVRepository}.</p>
     *
     * @param repo The owning {@link DAVRepository}
     * @param file The backing {@link java.io.File}
     * @return a <b>non-null</b> {@link DAVResource} instance.
     * @throws java.io.IOException If the resource could not be resolved.
     */
    DAVResource getResource( DAVRepository repo, File file );

}
